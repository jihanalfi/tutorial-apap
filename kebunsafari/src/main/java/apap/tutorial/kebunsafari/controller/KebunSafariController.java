package apap.tutorial.kebunsafari.controller;

import apap.tutorial.kebunsafari.service.KebunSafariService;
import apap.tutorial.kebunsafari.model.KebunSafariModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KebunSafariController {
    @Autowired
    private KebunSafariService kebunSafariService;

//    @RequestMapping("/error")
//    public String handleError() {
//        return "error";
//    }

    @RequestMapping("/kebun-safari/add")
    public String addKebunSafari(
        @RequestParam (value = "id", required = true) String idKebunSafari,
        @RequestParam (value = "nama", required = true) String namaKebunSafari,
        @RequestParam (value = "alamat", required = true) String alamat,
        @RequestParam (value = "noTelepon", required = true) String noTelepon,
        Model model
    ){
        // Membuat objek Kebun Safari baru
        KebunSafariModel kebunSafari = new KebunSafariModel(idKebunSafari, namaKebunSafari, alamat, noTelepon);

        // Memanggil service addKebunSadari
        kebunSafariService.addKebunSafari(kebunSafari);

        // Menambahkan variabel kebunSafari untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mereturn template html yang dipakai
        return "add-kebun-safari";
    }

    @RequestMapping("/")
    public String listKebunSafari(Model model){

        // Mendapatkan list seluruh object Kebun Safari
        List<KebunSafariModel> listKebunSafari = kebunSafariService.getKebunSafariList();

        // Menambahkan list untuk dirender di Thymeleaf
        model.addAttribute("listKebunSafari", listKebunSafari);

        // Mengembalikan template html yang dipakai
        return "get-all-kebun-safari";
    }

    @RequestMapping("/kebun-safari")
    public String getKebunSafariById(
            @RequestParam(value = "id", required = true) String idKebunSafari,
            Model model
    ){
        // Mendapatkan object Kebun Safari sesuai dengan ID yang dimasukkan
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        // Menambahkan object untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mengembalikan template html yang dipakai
        return "detail-kebun-safari";
    }

    @RequestMapping(value = "/kebun-safari/view/{idKebunSafari}")
    public String  getKebunSafariByIdWithPathVariable(
            @PathVariable(value = "idKebunSafari") String idKebunSafari,
            Model model
    ) {
        // Mendapatkan object Kebun Safari sesuai dengan ID yang dimasukkan
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        // Menambahkan object untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mengembalikan template html yang dipakai
        return "detail-kebun-safari";
    }

    @RequestMapping(value = "/kebun-safari/update/{idKebunSafari}")
    public String  updateTelepon(
            @PathVariable(value = "idKebunSafari") String idKebunSafari,
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ) {
        // Mendapatkan object Kebun Safari sesuai dengan ID yang dimasukkan
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        // Melakukan operasi nomor telepon
        kebunSafari.setNoTelepon(noTelepon);

        // Menambahkan object untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mengembalikan template html yang dipakai

        return "update-kebun-safari";
    }

    @RequestMapping(value = "/kebun-safari/delete/{idKebunSafari}")
    public String deleteKebunSafari(
            @PathVariable(value = "idKebunSafari") String idKebunSafari,
            Model model
    ) {
        // Mendapatkan object Kebun Safari sesuai dengan ID yang dimasukkan
        KebunSafariModel kebunSafari = kebunSafariService.getKebunSafariByIdKebunSafari(idKebunSafari);

        // menjalankan operasi delete
        kebunSafariService.deleteKebunSafari(kebunSafari);

        // Menambahkan object untuk dirender di Thymeleaf
        model.addAttribute("kebunSafari", kebunSafari);

        // Mengembalikan template html yang dipakai
        return "delete-kebun-safari";
    }

    @RequestMapping(value = "/kebun-safari/deleteByTelepon")
    public String deteleKebunSafariByTelepon(
            @RequestParam(value = "noTelepon", required = true) String noTelepon,
            Model model
    ) {

        kebunSafariService.deleteKebunSafariByNoTelpon(noTelepon);

        return "delete-kebun-safari-by-telepon";
    }
}

