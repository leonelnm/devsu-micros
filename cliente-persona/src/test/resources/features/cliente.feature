Feature: Cliente API

  Scenario: Crear cliente
    Given url 'http://localhost:8888/clientes'
    And request { nombre: 'Juan', apellido: 'Perez', email: 'juan@perez.com', telefono: '123456789' }
    When method post
    Then status 201

