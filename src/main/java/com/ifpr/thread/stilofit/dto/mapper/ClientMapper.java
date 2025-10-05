package com.ifpr.thread.stilofit.dto.mapper;

import com.ifpr.thread.stilofit.dto.ClientResponseDTO;
import com.ifpr.thread.stilofit.dto.list.ClientListDTO;
import com.ifpr.thread.stilofit.models.Client;

public class ClientMapper {

    public static ClientResponseDTO toResponse(Client client) {
        ClientResponseDTO dto = new ClientResponseDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        dto.setBirthDate(client.getBirthDate());
        dto.setGender(client.getGender());
        dto.setCpf(client.getCpf());
        dto.setEmail(client.getEmail());
        dto.setRg(client.getRg());
        dto.setMaritalStatus(client.getMaritalStatus());
        dto.setMedicalExamDueDate(client.getMedicalExamDueDate());
        dto.setStatus(client.getStatus());
        dto.setResponsibleName(client.getResponsibleName());
        dto.setResponsibleCpf(client.getResponsibleCpf());
        dto.setResponsiblePhone(client.getResponsiblePhone());
        dto.setEmergencieName(client.getEmergencieName());
        dto.setEmergenciePhone(client.getEmergenciePhone());
        dto.setEmergencieObs(client.getEmergencieObs());
        dto.setContactEmail(client.getContactEmail());
        dto.setContactPhone(client.getContactPhone());
        dto.setResidenceType(client.getResidenceType());
        dto.setCep(client.getCep());
        dto.setAddress(client.getAddress());
        dto.setNumber(client.getNumber());
        dto.setComplement(client.getComplement());
        dto.setNeighborhood(client.getNeighborhood());
        dto.setCity(client.getCity());
        dto.setState(client.getState());
        dto.setAddObs(client.getAddObs());
        dto.setConsultant(client.getConsultant());
        return dto;
    }

    public static ClientListDTO toList(Client client) {
        ClientListDTO dto = new ClientListDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());
        return dto;
    }
}
