
Feature: Uygulamaya Giriş Testi

  Scenario Outline: Uygulamaya başarılı giriş testi senaryosu
    Given browser açıldı
    When kullanıcı edevlet adresine gider ve <tckn> ile <sifre> girer
    Then kullanıcı çıkış yapar

   Examples:
     |   tckn    |  sifre  |
     |26503940896|edevlet123|

