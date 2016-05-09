package com.luvsoft.view.Customer;

import java.util.Collection;

import com.luvsoft.Excel.CustomerType1Exporter;
import com.luvsoft.Excel.CustomerType1Importer;
import com.luvsoft.entities.Customertype1;
import com.luvsoft.presenter.CustomerType1Presenter;
import com.luvsoft.utils.ACTION;
import com.luvsoft.utils.ErrorManager;
import com.luvsoft.utils.ErrorManager.ErrorId;
import com.luvsoft.view.component.FileChooser;
import com.luvsoft.view.component.FileImportHelper;
import com.luvsoft.view.component.GenericTabCategory;
import com.luvsoft.view.component.LuvsoftConfirmationDialog;
import com.luvsoft.view.validator.LuvsoftTableBeanValidator;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitEvent;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroup.CommitHandler;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.data.util.PropertysetItem;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;


public class CustomerType1View extends GenericTabCategory<Customertype1> {
    private static final long serialVersionUID = -7975276654447059817L;

    @SuppressWarnings("serial")
    public CustomerType1View() {
        presenter = new CustomerType1Presenter(this);
        super.init("Danh Sách Loại Khách Hàng 1", Customertype1.class)
        .withGeneralFuntionsList()
        .withTableProperties("name", "description")
        .withHeaderNames("name", "<b>Tên</b>")
        .withHeaderNames("description", "<b>Mô Tả</b>");

        //presenter.generateTable();
    
        for(TextField filter : this.getFilterFields()){
            filter.addTextChangeListener(new TextChangeListener() {
                @Override
                public void textChange(TextChangeEvent event) {
                    presenter.doFilter(getFilterFields().indexOf(filter), event.getText());
                }
            });
        }
    
        PropertysetItem stocktypeItem = new PropertysetItem();
        stocktypeItem.addItemProperty("name", new ObjectProperty<String>(""));
        stocktypeItem.addItemProperty("description", new ObjectProperty<String>(""));
        FieldGroup fieldGroup = new FieldGroup(stocktypeItem);
        fieldGroup.setBuffered(true);
    
        LuvsoftTableBeanValidator<Customertype1> nameValidator = new LuvsoftTableBeanValidator<Customertype1>(Customertype1.class, "name");
        this.content.getColumn("name").getEditorField().addValidator(nameValidator);
        LuvsoftTableBeanValidator<Customertype1> descritionValidator = new LuvsoftTableBeanValidator<Customertype1>(Customertype1.class, "description");
        this.content.getColumn("description").getEditorField().addValidator(descritionValidator);
        this.content.getEditorFieldGroup().addCommitHandler(new CommitHandler() {
    
            @Override
            public void preCommit(CommitEvent commitEvent) throws CommitException {
                Customertype1 type = (Customertype1) content.getEditedItemId();
                nameValidator.setEntity(type);
                nameValidator.setCalledByPreCommit(true);
            }
    
            @Override
            public void postCommit(CommitEvent commitEvent) {
                Customertype1 entity = (Customertype1) content.getEditedItemId();
                 presenter.updateEntity(entity, ACTION.UPDATE_BY_TABLE_EDITOR);
            }
        });
    }

    @Override
    public void initView() {
        presenter.generateTable();
    }

    /**
     * Do the stuff when Add button clicked
     */
    protected void onAddButtonClicked(){
        Customertype1 entity = new Customertype1();
        CustomerType1FormCreator form = new CustomerType1FormCreator();
        form.createForm(entity, presenter, ACTION.CREATE);
    }
    
    /**
     * Do the stuff when Edit button clicked
     */
    protected void onEditButtonClicked(){
        Customertype1 entity = null;
        for (Object object : content.getSelectedRows()) {
            entity = (Customertype1) object;
        }
        if(entity == null) {
            return;
        }

        CustomerType1FormCreator form = new CustomerType1FormCreator();
        form.createForm(entity, presenter, ACTION.UPDATE);
    }

    /**
     * Do the stuff when Delete button clicked
     */
    protected void onDeleteButtonClicked(){
        Collection<Object> selectedRows = content.getSelectedRows();
        LuvsoftConfirmationDialog dialog = new LuvsoftConfirmationDialog("Xác nhận xóa?");
        dialog.addLuvsoftClickListener(new ClickListener() {
            private static final long serialVersionUID = 351366856643651627L;

            @Override
            public void buttonClick(ClickEvent event) {
                for (Object object : selectedRows) {
                    presenter.deleteEntity((Customertype1) object);
                }
                content.deselectAll();
                dialog.close();
            }
        });

        // We do not show confirmation dialog if there is no selected item
        if(selectedRows.isEmpty()) {
            return;
        }

        UI.getCurrent().addWindow(dialog);
    }

    @Override
    protected void onExcelImportButtonClicked() {
        getContent().getUI().addWindow(new FileImportHelper<Customertype1>(new CustomerType1Importer(), this));
    }

    @SuppressWarnings("serial")
    @Override
    protected void onExcelExportButtonClicked() {
        FileChooser fileChooser = new FileChooser("/", true);
        this.getContent().getUI().addWindow(fileChooser);
        fileChooser.addCloseListener(new CloseListener() {
            @Override
            public void windowClose(CloseEvent e) {
                if( fileChooser.getChoosenFile() != null ){
                    CustomerType1Exporter exporter = new CustomerType1Exporter(fileChooser.getChoosenFile());
                    ErrorId error = exporter.export();
                    if( error == ErrorId.EXCEL_EXPORT_NOERROR){
                        ErrorManager.getInstance().notifyWarning(error, "");
                    }
                    else{
                        ErrorManager.getInstance().raiseError(error, "");
                    }
                }
            }
        });
    }
}
