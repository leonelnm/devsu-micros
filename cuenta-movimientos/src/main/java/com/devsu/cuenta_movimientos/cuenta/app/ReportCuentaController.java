package com.devsu.cuenta_movimientos.cuenta.app;

import com.devsu.cuenta_movimientos.cuenta.domain.ReportCuentaService;
import com.devsu.cuenta_movimientos.cuenta.infra.dto.ReportCuentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReportCuentaController {

    @Autowired
    private ReportCuentaService service;

    @GetMapping
    public List<ReportCuentaDTO> getReportCuentas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha,
            @RequestParam(value = "cliente") Long clienteid) {
        return service.getReportCuentas(fecha, clienteid);
    }

}
