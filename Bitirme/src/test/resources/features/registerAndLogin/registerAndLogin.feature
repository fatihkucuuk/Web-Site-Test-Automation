Feature: Kullanıcı Kayıt ve Giriş İşlemleri

  Scenario: Kayıt olma ve kayıt yapılan user ile giriş yapma
    Given kullanıcı anasayfaya yönlendirilir
    And mouse userLogosunun üzerine getirilir
    And kayıt ol sekmesine tıklanır
    When kullanıcı kayıt olma işlemi yapar
    And mouse userLogosunun üzerine getirilir
    And giriş yap sekmesine tıklanır
    And kullanıcı login işlemi yapar
    Then uygulama kapatılır

  Scenario: Giriş yapma ve şifre değiştirme
    Given kullanıcı anasayfaya yönlendirilir
    And mouse userLogosunun üzerine getirilir
    And giriş yap sekmesine tıklanır
    When kullanıcı login işlemi yapar
    And mouse userLogosunun üzerine getirilir
    And hesabım sekmesine tıklanır
    When kullanıcı şifre güncelleme işlemi yapar
    Then uygulama kapatılır

  Scenario: İletişim sayfasından mail formu doldurma
    Given kullanıcı anasayfaya yönlendirilir
    And kullanıcı iletişim sekmesine tıklar
    When kullanıcı mail gönderme işlemi yapar
    Then uygulama kapatılır