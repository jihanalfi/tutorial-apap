package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.CabangModel;
import apap.tutorial.emsidi.model.PegawaiModel;
import apap.tutorial.emsidi.repository.PegawaiDb;
import apap.tutorial.emsidi.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PegawaiRestServiceImpl implements PegawaiRestService {
    private final WebClient webClient;

    public  PegawaiRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.agify).build();
    }

    @Override
    public PegawaiModel getAge(Long noPegawai){
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        HashMap hashhash = webClient.get().uri("https://api.agify.io/?name="+pegawai.getNamaPegawai())
                .retrieve()
                .bodyToMono(HashMap.class)
                .block();
        pegawai.setUmur(Integer.parseInt(hashhash.get("age").toString()));
        return pegawai;
        // System.out.print(pegawaiResult);
        //return webClient.get().uri("https://api.agify.io/?name=" + pegawai.getNamaPegawai())
        //        .retrieve()
        //        .bodyToMono(PegawaiModel.class);
        //return this.webClient.get().uri("/api/v1/pegawai/umur/" + noPegawai)
        //        .retrieve().bodyToMono(String.class);
    }

    @Autowired
    private PegawaiDb pegawaiDb;

    @Override
    public PegawaiModel createPegawai(PegawaiModel pegawai){
        return pegawaiDb.save(pegawai);
    }

    @Override
    public List<PegawaiModel> retrieveListPegawai(){
        return pegawaiDb.findAll();
    }

    @Override
    public PegawaiModel getPegawaiByNoPegawai(Long noPegawai){
        Optional<PegawaiModel> pegawai = pegawaiDb.findByNoPegawai(noPegawai);
        if(pegawai.isPresent()){
            return pegawai.get();
        }
        return null;
    }

    @Override
    public PegawaiModel updatePegawai(Long noPegawai, PegawaiModel pegawaiUpdate){
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();

        if (now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())){
            pegawai.setNamaPegawai(pegawaiUpdate.getNamaPegawai());
            pegawai.setJenisKelamin(pegawaiUpdate.getJenisKelamin());
            pegawai.setCabang(pegawaiUpdate.getCabang());
            return pegawaiDb.save(pegawai);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public void deletePegawai(Long noPegawai){
        LocalTime now = LocalTime.now();
        PegawaiModel pegawai = getPegawaiByNoPegawai(noPegawai);
        CabangModel cabang = pegawai.getCabang();

        if (now.isBefore(cabang.getWaktuBuka()) || now.isAfter(cabang.getWaktuTutup())){
            pegawaiDb.delete(pegawai);
        } else {
            throw new UnsupportedOperationException();
        }

    }
}
