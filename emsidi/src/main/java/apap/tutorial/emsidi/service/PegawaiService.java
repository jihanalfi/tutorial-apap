package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.PegawaiModel;

public interface PegawaiService {
    void addPegawai(PegawaiModel pegawai);

    void updatePegawai(PegawaiModel pegawai);

    void deletePegawai(Long id);

    PegawaiModel getPegawaiByNoPegawai(Long noPegawai);
}
