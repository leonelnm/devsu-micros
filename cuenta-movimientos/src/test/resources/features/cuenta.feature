Feature: Api Cuenta

  Background:
    * url 'http://localhost:8889'

  Scenario: Crear y verificar una cuenta

    # Crear una nueva cuenta
    Given path 'cuentas'
    And request { numero: '4787589', tipo: 'AHORROS', saldo: 2000, estado: true, clienteid: 1 }
    When method post
    Then status 201
    And match response.numero == '4787589'
    And match response.tipo == 'AHORROS'
    And match response.saldo == 2000
    And match response.estado == true

    # Verificar la cuenta creada
    Given path 'cuentas'
    When method get
    Then status 200
    And match response[0].numero == '4787589'