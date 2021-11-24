package apap.tutorial.emsidi.controller;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.MenuModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.service.CabangService;
import apap.tutorial.emsidi.service.MenuService;
import apap.tutorial.emsidi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
public class CabangController {
    public int counter = 1;

    @Qualifier("cabangServiceImpl")
    @Autowired
    private CabangService cabangService;

    @Qualifier("menuServiceImpl")
    @Autowired
    MenuService menuService;

    @Autowired
    private UserService userService;

    @GetMapping(value="/cabang/add")
    public String addCabangForm(
            HttpServletRequest request,
            Model model) {
        counter = 1;
        List<MenuModel> listAllMenu = menuService.getListMenu();
        Principal principal = request.getUserPrincipal();
        UserModel user = userService.getUser(principal.getName());

        model.addAttribute("listAllMenu", listAllMenu);
        model.addAttribute("counter", counter);
        model.addAttribute("cabang", new CabangModel());
        model.addAttribute("role", user.getRole().getRole());
        return "form-add-cabang";
    }

    @PostMapping(value = "/cabang/add", params = {"addRow"})
    public String tambahRow(
            @ModelAttribute CabangModel cabang,
            BindingResult bindingResult,
            Model model
    ){
        List<MenuModel> listMenu = menuService.getListMenu();
        if(cabang.getListMenu()==null){
            cabang.setListMenu(new ArrayList<MenuModel>());
        }
        List<MenuModel> listMenuRow = cabang.getListMenu();
        listMenuRow.add(new MenuModel());
        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenu", listMenu);
        return "form-add-cabang";

    }

    @RequestMapping(value = "/cabang/add", method = RequestMethod.POST, params = {"deleteRow"})
    public String deleteRow(
            @ModelAttribute CabangModel cabang,
            final BindingResult bindingResult,
            Model model,
            final HttpServletRequest request
    ){

        List<MenuModel> listMenu = menuService.getListMenu();

        final Integer numRow = Integer.valueOf(request.getParameter("deleteRow"));
        cabang.getListMenu().remove(numRow.intValue());
        model.addAttribute("cabang", cabang);
        model.addAttribute("listMenu", listMenu);
        return "form-add-cabang";

    }

    @PostMapping("/cabang/add")
    public String addCabangSubmit(
            @ModelAttribute CabangModel cabang,
            Model model
    ) {
        cabangService.addCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        return "add-cabang";
    }


    @GetMapping("/cabang/viewall")
    public String listCabang(Model model) {
        List<CabangModel> listCabang = cabangService.getCabangList();
        LocalTime localTime = LocalTime.now();

        model.addAttribute("localTime", localTime);
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }

    // Latihan 1: Terurut berdasarkan nama cabang
    @GetMapping("/cabang/viewAll")
    public String listCabangTerurut(Model model) {
        List<CabangModel> listCabang = cabangService.getCabangListSorted();
        LocalTime localTime = LocalTime.now();

        model.addAttribute("localTime", localTime);
        model.addAttribute("listCabang", listCabang);
        return "viewall-cabang";
    }


    @GetMapping("/cabang/view")
    public String viewDetailCabang(
            @RequestParam(value = "noCabang") Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        List<MenuModel> listMenu = cabang.getListMenu();
        List<PegawaiModel> listPegawai = cabang.getListPegawai();

        LocalTime localTime = LocalTime.now();
        model.addAttribute("localTime", localTime);
        model.addAttribute("cabang", cabang);
        model.addAttribute("listPegawai", listPegawai);
        model.addAttribute("listMenu", listMenu);
        return "view-cabang";
    }

    @GetMapping("/cabang/update/{noCabang}")
    public String updateCabangForm(
            @PathVariable Long noCabang,
            Model model
    ) {
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);

        model.addAttribute("cabang", cabang);
        return "form-update-cabang";
    }

    @PostMapping("/cabang/update")
    public String updateCabangSubmit(
            @ModelAttribute CabangModel cabang,
            @ModelAttribute HashSet<String> listStringMenu,
            Model model
    ) {
        cabangService.updateCabang(cabang);
        model.addAttribute("noCabang", cabang.getNoCabang());
        model.addAttribute("listMenu", listStringMenu);
        return "update-cabang";
    }

    // Latihan 4: Delete Cabang saat tidak memiliki pegawai dan sedang tutup
    @GetMapping("/cabang/delete/{noCabang}")
    public String deleteCabang(@PathVariable Long noCabang, Model model) {
        LocalTime now = LocalTime.now();
        CabangModel cabang = cabangService.getCabangByNoCabang(noCabang);
        if ((now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup()))
                && cabang.getListPegawai().isEmpty()) {
            cabangService.removeCabang(cabang);
            model.addAttribute("noCabang", cabang.getNoCabang());
            return "delete-cabang";
        }
        return "error-cannot-delete";
    }

}
