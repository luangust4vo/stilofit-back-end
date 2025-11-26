package com.ifpr.thread.stilofit.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.ifpr.thread.stilofit.dto.ClientRequestDTO;
import com.ifpr.thread.stilofit.exceptions.CpfAlreadyRegisteredException;
import com.ifpr.thread.stilofit.exceptions.NotBlankException;
import com.ifpr.thread.stilofit.exceptions.NotFoundException;
import com.ifpr.thread.stilofit.models.Client;
import com.ifpr.thread.stilofit.repositories.ClientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client create(ClientRequestDTO clientRequestDTO) {
        validateClientFields(clientRequestDTO);

        if (clientRepository.existsByCpf(clientRequestDTO.getCpf())) {
            throw new CpfAlreadyRegisteredException("CPF já cadastrado");
        }

        Client client = new Client();
        client.setName(clientRequestDTO.getName());
        client.setBirthDate(clientRequestDTO.getBirthDate());
        client.setGender(clientRequestDTO.getGender());
        client.setCpf(clientRequestDTO.getCpf());
        client.setRg(clientRequestDTO.getRg());
        client.setEmail(clientRequestDTO.getEmail());
        client.setMaritalStatus(clientRequestDTO.getMaritalStatus());
        client.setMedicalExamDueDate(clientRequestDTO.getMedicalExamDueDate());
        client.setStatus(clientRequestDTO.getStatus());
        client.setResponsibleName(clientRequestDTO.getResponsibleName());
        client.setResponsibleCpf(clientRequestDTO.getResponsibleCpf());
        client.setResponsiblePhone(clientRequestDTO.getResponsiblePhone());
        client.setEmergencieName(clientRequestDTO.getEmergencieName());
        client.setEmergenciePhone(clientRequestDTO.getEmergenciePhone());
        client.setEmergencieObs(clientRequestDTO.getEmergencieObs());
        client.setContactEmail(clientRequestDTO.getContactEmail());
        client.setContactPhone(clientRequestDTO.getContactPhone());
        client.setResidenceType(clientRequestDTO.getResidenceType());
        client.setCep(clientRequestDTO.getCep());
        client.setAddress(clientRequestDTO.getAddress());
        client.setNumber(clientRequestDTO.getNumber());
        client.setComplement(clientRequestDTO.getComplement());
        client.setNeighborhood(clientRequestDTO.getNeighborhood());
        client.setCity(clientRequestDTO.getCity());
        client.setState(clientRequestDTO.getState());
        client.setAddObs(clientRequestDTO.getAddObs());
        client.setConsultant(clientRequestDTO.getConsultant());

        Client clientSave = clientRepository.save(client);
        return clientSave;
    }

    public Client findById(@NonNull Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));
    }

    public Page<Client> findAll(@NonNull Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public Client update(@NonNull Long id, ClientRequestDTO clientRequestDTO) {
        validateClientFields(clientRequestDTO);

        Client existClient = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado com id: " + id));

        existClient.setName(clientRequestDTO.getName());
        existClient.setBirthDate(clientRequestDTO.getBirthDate());
        existClient.setGender(clientRequestDTO.getGender());
        existClient.setRg(clientRequestDTO.getRg());
        existClient.setEmail(clientRequestDTO.getEmail());
        existClient.setMaritalStatus(clientRequestDTO.getMaritalStatus());
        existClient.setMedicalExamDueDate(clientRequestDTO.getMedicalExamDueDate());
        existClient.setStatus(clientRequestDTO.getStatus());
        existClient.setResponsibleName(clientRequestDTO.getResponsibleName());
        existClient.setResponsibleCpf(clientRequestDTO.getResponsibleCpf());
        existClient.setResponsiblePhone(clientRequestDTO.getResponsiblePhone());
        existClient.setEmergencieName(clientRequestDTO.getEmergencieName());
        existClient.setEmergenciePhone(clientRequestDTO.getEmergenciePhone());
        existClient.setEmergencieObs(clientRequestDTO.getEmergencieObs());
        existClient.setContactEmail(clientRequestDTO.getContactEmail());
        existClient.setContactPhone(clientRequestDTO.getContactPhone());
        existClient.setResidenceType(clientRequestDTO.getResidenceType());
        existClient.setCep(clientRequestDTO.getCep());
        existClient.setAddress(clientRequestDTO.getAddress());
        existClient.setNumber(clientRequestDTO.getNumber());
        existClient.setComplement(clientRequestDTO.getComplement());
        existClient.setNeighborhood(clientRequestDTO.getNeighborhood());
        existClient.setCity(clientRequestDTO.getCity());
        existClient.setState(clientRequestDTO.getState());
        existClient.setAddObs(clientRequestDTO.getAddObs());
        existClient.setConsultant(clientRequestDTO.getConsultant());

        Client updateClient = clientRepository.save(existClient);
        return updateClient;
    }

    private void validateClientFields(ClientRequestDTO clientRequestDTO) {
        if (clientRequestDTO.getName() == null || clientRequestDTO.getName().isBlank()) {
            throw new NotBlankException("O campo 'nome' é obrigatório.");
        }
        if (clientRequestDTO.getBirthDate() == null) {
            throw new NotBlankException("O campo 'data de nascimento' é obrigatório.");
        }
        if (clientRequestDTO.getGender() == null) {
            throw new NotBlankException("O campo 'gênero' é obrigatório.");
        }
    }
}
