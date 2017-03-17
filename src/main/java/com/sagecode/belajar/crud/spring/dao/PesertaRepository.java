package com.sagecode.belajar.crud.spring.dao;

import com.sagecode.belajar.crud.spring.entity.Peserta;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PesertaRepository extends PagingAndSortingRepository<Peserta,String>{
    
}
