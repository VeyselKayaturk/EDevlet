Feature: Danıştay-Dava Dosyası Sorgulama hizmeti testi

  Scenario Outline: Dava dosyası olması senaryosu
    Given browser açıldı
    When kullanıcı edevlet adresine gider ve <tckn> ile <sifre> girer
   #When kullanıcı anasayfada yer alan kurumlar menüsüne tıklar
    And kullanıcı Kurum alfabesinde yer D harfine tıklar
    And kullanıcı listeden Danıştay Başkanlığına tıklar
    And kullanıcı açılan hizmet listesinde yer alan Dava Dosyası Sorgulama hizmetine fare imleci ile odaklanır
    Then açılan ipucu ifadesini doğrulanır
    And kullanıcı açılan hizmet listesinde yer alan Dava Dosyası Sorgulama hizmetine tıklanır
    Then açılan ekranda yer alan içerikleri doğrulanır
    When kullanıcı ekranda yer alan Görüntüle düğmesine tıklar
    Then hizmete ait detay ekranı açılır ve ekrandaki içerik doğrulanır
    When kullanıcı Geri düğmesine tıklar
    Then kullanıcı Dava Dosyası Sorgulama hizmeti ana ekranına döner
    Then kullanıcı çıkış yapar
    Examples:
      |   tckn    |  sifre  |
      |35773241350|edevlet123|

 Scenario Outline:  Dava dosyası olmaması senaryosu
   Given browser açıldı
   When kullanıcı edevlet adresine gider ve <tckn> ile <sifre> girer
   When kullanıcı anasayfada yer alan kurumlar menüsüne tıklar
   And kullanıcı Kurum alfabesinde yer D harfine tıklar
   And kullanıcı listeden Danıştay Başkanlığına tıklar
   And kullanıcı açılan hizmet listesinde yer alan Dava Dosyası Sorgulama hizmetine fare imleci ile odaklanır
   Then açılan ipucu ifadesini doğrulanır
   And kullanıcı açılan hizmet listesinde yer alan Dava Dosyası Sorgulama hizmetine tıklanır
   Then açılan ekranda dosya olmadığına dair uyaru mesajı ve hizmet açıklamasının yer aldığı içerikleri doğrulanır
   Then kullanıcı çıkış yapar
   Examples:
     |   tckn    |  sifre  |
     |59318150754|edevlet123|