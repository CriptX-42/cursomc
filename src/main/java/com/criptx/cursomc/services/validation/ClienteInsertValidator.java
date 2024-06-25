package com.criptx.cursomc.services.validation;

import com.criptx.cursomc.domain.enums.TipoCliente;
import com.criptx.cursomc.dto.ClienteNewDTO;
import com.criptx.cursomc.repositories.ClienteRepository;
import com.criptx.cursomc.resource.exceptions.FieldMessage;
import com.criptx.cursomc.services.validation.utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();

        // inclua os testes aqui, inserindo erros na lista
        if(objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCode()) && !BR.isValidCPF(objDto.getCpfOuCnpj())){
            list.addAll((Collection<? extends FieldMessage>) new FieldMessage("cpfOuCnpj", "CPF inválido"));
        }

        if(objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCode()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())){
            list.addAll((Collection<? extends FieldMessage>) new FieldMessage("cpfOuCnpj", "CNPJ inválido"));
        }

        if(repo.findByEmail(objDto.getEmail()) != null) {
            list.addAll((Collection<? extends FieldMessage>) new FieldMessage("Email", "email já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
