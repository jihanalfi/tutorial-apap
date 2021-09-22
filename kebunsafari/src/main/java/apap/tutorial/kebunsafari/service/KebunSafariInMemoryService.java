package apap.tutorial.kebunsafari.service;

import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class KebunSafariInMemoryService implements KebunSafariService{
    private List<KebunSafariModel> listKebunSafari;

    // Constructor
    public KebunSafariInMemoryService() {
        listKebunSafari = new ArrayList<>();
    }

    @Override
    public void addKebunSafari(KebunSafariModel kebunSafari){
        listKebunSafari.add(kebunSafari);
    }

    @Override
    public void deleteKebunSafari(KebunSafariModel kebunSafari){
        if (listKebunSafari.contains(kebunSafari)) {
            listKebunSafari.remove(kebunSafari);
        }
    }

    @Override
    public List<KebunSafariModel> getKebunSafariList(){
        return listKebunSafari;
    }

    @Override
    public KebunSafariModel getKebunSafariByIdKebunSafari(String idKebunSafari){
        for (KebunSafariModel kebunSafari : listKebunSafari){
            if (kebunSafari.getIdKebunSafari().equals(idKebunSafari)) {
                // System.out.print("masuk if");
                return kebunSafari;
            }
        }
        return null;
    }

    @Override
    public void deleteKebunSafariByNoTelpon(String noTelepon){
        List<KebunSafariModel> listKebunSafariNomor = new ArrayList<>();
        for (KebunSafariModel kebunSafari : listKebunSafari){
            if (kebunSafari.getNoTelepon().equals(noTelepon)) {
                listKebunSafariNomor.add(kebunSafari);
            }
        }
        if (!listKebunSafariNomor.isEmpty()){
            for (KebunSafariModel kebunSafari : listKebunSafariNomor){
                deleteKebunSafari(kebunSafari);
            }
        }

    }

}
