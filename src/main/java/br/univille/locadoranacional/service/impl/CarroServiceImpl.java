package br.univille.locadoranacional.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.univille.locadoranacional.entity.Carro;
import br.univille.locadoranacional.repository.CarroRepository;
import br.univille.locadoranacional.service.CarroService;

@Service
public class CarroServiceImpl implements CarroService {
    
    @Value("${applocadoranacional.tempfolder}")
    private String tempFolder;
    private Path root = null;

    @Autowired
    private CarroRepository repositorio;

    @Override
    public List<Carro> getAll() {
        return repositorio.findAll();
    }

    @Override
    public Carro getOne(long id) {
        var resultado = repositorio.findById(id);
        if(resultado.isPresent()) {
            return resultado.get();
        }

        return new Carro();
    }

    @Override
    public Carro save(Carro carro) {
        return repositorio.save(carro);
    }

    @Override
    public void delete(long id) {
        repositorio.deleteById(id);        
    }

    @Override
    public String salvarFoto(MultipartFile file) {
        File dir = new File(tempFolder);
        if(! dir.exists()) {
            dir.mkdir();
        }

        root = Paths.get(tempFolder);
        UUID uuid = UUID.randomUUID();
        String novoNome = String.format("%s.%s", uuid.toString(),
            file.getOriginalFilename().split("\\.")[1]);

        Path nomeArquivo = this.root.resolve(novoNome);
        try {
            Files.copy(file.getInputStream(), nomeArquivo);
        } catch(Exception e) {
            throw new RuntimeException("Não foi possível salvar o arquivo");
        }

        return nomeArquivo.toAbsolutePath().toString();
    }


}
