package com.codegym.service.tables;

import com.codegym.model.Tables;
import com.codegym.repository.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class TablesService implements ITablesService{
    @Autowired
    private TablesRepository tablesRepository;
    @Override
    public Iterable<Tables> findAll() {
        return tablesRepository.findAll();
    }

    @Override
    public Optional<Tables> findById(Long id) {
        return tablesRepository.findById(id);
    }

    @Override
    public Tables save(Tables tables) {
        return tablesRepository.save(tables);
    }

    @Override
    public void remove(Long id) {
        tablesRepository.deleteById(id);
    }
}
