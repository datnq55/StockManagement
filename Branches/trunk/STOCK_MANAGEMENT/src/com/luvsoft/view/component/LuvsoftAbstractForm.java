package com.luvsoft.view.component;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.viritin.form.AbstractForm;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.luvsoft.entities.AbstractEntity;
import com.luvsoft.presenter.UpdateEntityListener;
import com.luvsoft.utils.ACTION;
import com.luvsoft.view.validator.LuvsoftFormBeanValidator;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;

public class LuvsoftAbstractForm<T extends AbstractEntity> extends AbstractForm<T>{
    private static final long serialVersionUID = -7144760489697191396L;

    protected List<AbstractComponent> listComponents = new ArrayList<AbstractComponent>();
    protected List<LuvsoftFormBeanValidator<AbstractEntity>> listValidators = new ArrayList<LuvsoftFormBeanValidator<AbstractEntity>>();
    private ACTION action;
    private UpdateEntityListener presenter;
    private T cloneEntity;

    // List of available components
    protected TextField code;
    protected TextField name;
    protected TextArea description;
    protected ComboBox stocktype;

    public LuvsoftAbstractForm(UpdateEntityListener presenter, ACTION action, T cloneEntity) {
        setEagerValidation(true);
        this.action = action;
        this.presenter = presenter;
        this.presenter.setAction(action);
        this.cloneEntity = cloneEntity;
    }

    /**
     * Override this method to build specific field layout
     * @return
     */
    protected MVerticalLayout buildFieldLayouts(){
        MVerticalLayout wrapper = new MVerticalLayout();
        for (AbstractComponent component : listComponents) {
            wrapper.add(component);
        }
        return wrapper;
    }

    @Override
    protected Component createContent() {
        this.setSizeUndefined();
        // build field layouts
        MVerticalLayout wrapper = buildFieldLayouts();

        Button save = new Button("Lưu");
        save.addStyleName(ValoTheme.BUTTON_FRIENDLY);
        save.setIcon(FontAwesome.CHECK);
        save.setClickShortcut(KeyCode.ENTER, ModifierKey.ALT);

        Button reset = new Button("Làm Mới");
        reset.setIcon(FontAwesome.REFRESH);
        reset.setClickShortcut(KeyCode.R, ModifierKey.ALT);

        setResetButton(reset);
        setSaveButton(save);

        wrapper.add(getToolbar());
        return wrapper;
    }

    @Override
    public Window openInModalPopup() {
        super.openInModalPopup();
        getPopup().setDraggable(false);
        getPopup().setResizable(false);
        getPopup().setCaptionAsHtml(true);
        if(action.equals(ACTION.CREATE)) {
            getPopup().setCaption("<b>Tạo mới</b>");
        }
        if(action.equals(ACTION.UPDATE)) {
            getPopup().setCaption("<b>Cập nhật thông tin</b>");
        }
        return getPopup();
    }

    /**
     * Add validators for all components (fields) of this form
     * Call this method after creation of all fields
     */
    @SuppressWarnings("unchecked")
    public void addValidators() {
        for(int i=0; i<listComponents.size(); i++) {
            if( i < listValidators.size() && listValidators.get(i) != null ){
                addValidator(listValidators.get(i), listComponents.get(i));
            }
        }
    }

    public void handleSaveAndResetOperations() {
        if(presenter == null) return;

        setResetHandler(new ResetHandler<T>() {
            @SuppressWarnings("unchecked")
            @Override
            public void onReset(T entity) {
                entity = (T) cloneEntity.cloneObject();
                setEntity(entity);
            }
        });

        setSavedHandler(new SavedHandler<T>() {
            @Override
            public void onSave(T entity) {
                if(entity == null) {
                    return;
                }
                else {
                    entity.verifyObject();
                }

                presenter.updateEntity(entity);

                // Close window when modification is finished
                if(getPopup() != null) {
                    getPopup().close();
                }
            }
        });
    }

    /**
     * Create a text field for form
     * @param caption => the caption of text field
     * @param beanClass => the class type
     * @param propertyName => the property name (corresponding to the name in JPA annotation)
     */
    public void createTextField(String caption, Class<?> beanClass, String propertyName) {
        switch (propertyName) {
            case "name":
                name = new TextField();
                name.setCaption(caption);
                listComponents.add(name);
                listValidators.add(new LuvsoftFormBeanValidator<AbstractEntity>(beanClass, propertyName));
                break;
            case "code":
                code = new TextField();
                code.setCaption(caption);
                listComponents.add(code);
                listValidators.add(new LuvsoftFormBeanValidator<AbstractEntity>(beanClass, propertyName));
                break;
            case "description":
                description = new TextArea();
                description.setCaption(caption);
                listComponents.add(description);
                listValidators.add(new LuvsoftFormBeanValidator<AbstractEntity>(beanClass, propertyName));
                break;
            case "stocktype":
                stocktype = new ComboBox();
                stocktype.setCaption(caption);
                stocktype.setNullSelectionAllowed(false);
                stocktype.setNewItemsAllowed(false);
                listComponents.add(stocktype);
                listValidators.add(new LuvsoftFormBeanValidator<AbstractEntity>(beanClass, propertyName));
                break;
            default:
                break;
        }
    }

    public List<AbstractComponent> getListComponents() {
        return listComponents;
    }

    public void setListComponents(List<AbstractComponent> listComponents) {
        this.listComponents = listComponents;
    }

    public List<LuvsoftFormBeanValidator<AbstractEntity>> getListValidators() {
        return listValidators;
    }

    public void setListValidators(
            List<LuvsoftFormBeanValidator<AbstractEntity>> listValidators) {
        this.listValidators = listValidators;
    }

    public ComboBox getStocktype() {
        return stocktype;
    }

    public void setStocktype(ComboBox stocktype) {
        this.stocktype = stocktype;
    }
}
