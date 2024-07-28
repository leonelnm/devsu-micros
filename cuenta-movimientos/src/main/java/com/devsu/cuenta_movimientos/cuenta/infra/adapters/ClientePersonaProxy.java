package com.devsu.cuenta_movimientos.cuenta.infra.adapters;

import com.devsu.cuenta_movimientos.cuenta.infra.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientePersonaProxy {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${proxy.cliente-persona.cliente-url}")
    private String clienteUrl;

    public boolean clienteExiste(Long clienteid) {
        try {
            if (clienteid == null) {
                return false;
            }

            String url = String.format("%s/%d", clienteUrl, clienteid);
            ResponseEntity<Void> response = restTemplate.getForEntity(url, Void.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return false;
            }
            return false;
        }
    }

    public ClienteDTO getCliente(Long clienteid) {
        try {
            String url = String.format("%s/%d", clienteUrl, clienteid);
            ResponseEntity<ClienteDTO> response = restTemplate.getForEntity(url, ClienteDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                return null;
            }
            return null;
        }
    }
}
