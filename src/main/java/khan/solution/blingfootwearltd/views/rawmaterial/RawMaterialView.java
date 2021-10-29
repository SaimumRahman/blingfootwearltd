package khan.solution.blingfootwearltd.views.rawmaterial;


import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.customfield.CustomField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import khan.solution.blingfootwearltd.data.model.RawMaterial;
import khan.solution.blingfootwearltd.data.service.RawMaterialService;
import khan.solution.blingfootwearltd.views.MainLayout;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.component.dependency.Uses;

import java.util.List;

@PageTitle("Raw Material Input")
@Route(value = "rawmaterials", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@Uses(Icon.class)
public class RawMaterialView extends Div {

    private Grid<RawMaterial> grid=new Grid<>(RawMaterial.class);

    private TextField nameRM = new TextField("Raw Material Name");
    private TextField costRM = new TextField("Raw Material Cost");
    private TextField quantityRM = new TextField("Raw Material Quantity");
    private TextField boughtFromRM = new TextField("Buy Location");

    private Button cancel = new Button("Cancel");
    private Button save = new Button("Save");

    private Binder<RawMaterial> binder = new Binder(RawMaterial.class);

    public RawMaterialView(RawMaterialService rawMaterialService) {
        addClassName("raw-material-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());
        add(grid);


        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());
        save.addClickListener(e -> {
            rawMaterialService.createRawMaterialInput(binder.getBean());
            Notification.show(binder.getBean().getClass().getSimpleName() + " details stored.");
            clearForm();
            updateList(rawMaterialService);
        });

        updateList(rawMaterialService);
    }

    private void clearForm() {
        binder.setBean(new RawMaterial());
    }

    private Component createTitle() {
        return new H3("Raw Material Input");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(nameRM, costRM, quantityRM, boughtFromRM);
        return formLayout;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(save);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

    private void configureGrid() {
        grid.addClassName("Raw-Material-Grid");
        grid.setSizeFull();
        grid.setColumns("rawMaterialId","nameRM","costRM","quantityRM","boughtFromRM","dateRM");

    }
    private void updateList(RawMaterialService service) {
        List<RawMaterial> up=service.getAllRawMaterials();
        if (up.isEmpty()){
            Notification.show("No Data Found");
        }
        else {
            grid.setItems(up);
        }
    }

}
