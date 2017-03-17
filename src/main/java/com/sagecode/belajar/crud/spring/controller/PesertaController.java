package com.sagecode.belajar.crud.spring.controller;

import com.sagecode.belajar.crud.spring.dao.PesertaRepository;
import com.sagecode.belajar.crud.spring.entity.Peserta;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PesertaController {
    
    @Autowired
    private PesertaRepository pr;
     
    @RequestMapping(value="/peserta", method = RequestMethod.GET )
    public Page<Peserta> cariPeserta(Pageable page){
        return pr.findAll(page);
    }
    
//    @RequestMapping(value="/peserta", method = RequestMethod.POST )    
//    @ResponseStatus(HttpStatus.CREATED)
//    public void insertPesertaBaru(@RequestParam String name,@RequestParam String email,
//                                    @RequestParam Date tanggalLahir){
//        Peserta p = new Peserta();
//        p.setNama(name);
//        p.setEmail(email);
//        p.setTanggalLahir(tanggalLahir);
//        pr.save(p);
//    }
    
    @RequestMapping(value="/peserta", method = RequestMethod.POST )    
    @ResponseStatus(HttpStatus.CREATED)
    public void insertPesertaBaru(@RequestBody Peserta p){
        
        pr.save(p);
    }
    
    @RequestMapping(value="/peserta/{id}", method = RequestMethod.PUT )
    @ResponseStatus(HttpStatus.OK)
    public void updatePeserta(@PathVariable("id") String id, @RequestBody Peserta p){
        p.setId(id);
        pr.save(p);
    }
    
    @RequestMapping(value="/peserta/{id}", method = RequestMethod.GET )
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Peserta> cariPesertaById(@PathVariable("id") String id){
        Peserta hasil = pr.findOne(id);
        if(hasil == null){
            return new ResponseEntity <>(hasil,HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity <>(hasil,HttpStatus.OK);
    }
    
    @RequestMapping(value="/peserta/{id}", method = RequestMethod.DELETE )
    @ResponseStatus(HttpStatus.OK)
    public void hapusPeserta(@PathVariable("id") String id){
        pr.delete(id);
    }
}
