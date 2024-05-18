package co.edu.uptc;

import co.edu.uptc.interfaces.VeterinaryInterface;
import co.edu.uptc.models.VeterinaryManagerModel;
import co.edu.uptc.presenters.Presenter;
import co.edu.uptc.views.veterinaryClinicMainFrame.veterinatyClinicMainFrame.VeterinaryClinicView;

public class App {
    public static void main( String[] args ){
        VeterinaryInterface.Model model= new VeterinaryManagerModel();
        VeterinaryInterface.Presenter presenter = new Presenter();
        VeterinaryInterface.View view = new VeterinaryClinicView();
        model.setPresenter(presenter);
        view.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
        view.begin();
    }
}
