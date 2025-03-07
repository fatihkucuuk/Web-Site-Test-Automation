Feature: Kullanıcı Girişi Sonrası Yapılan Fonksiyonlar

  Scenario: Giriş yapma, ürünler sayfasına gitme, ürün sıralama, ürün arama, detay görüntüleme, yorum ekleme
    Given kullanıcı anasayfaya yönlendirildi
    And mouse userLogosunun üzerine getirildi
    And giriş yap sekmesine tıklandı
    When kullanıcı login işlemi yaptı
    And kullanıcı ürünler sayfasına girer
    And kullanıcı ürün sıralar
    And kullanıcı isme göre ürün arar
    And kullanıcı aradığı ürüne tıklar
    And kullanıcı aradığı ürüne yorum ekler
    Then uygulama kapatıldı

  Scenario: Giriş yapma, ürünler sayfasına girme, ürün arama, detay görüntüleme, soru sorma
    Given kullanıcı anasayfaya yönlendirildi
    And mouse userLogosunun üzerine getirildi
    And giriş yap sekmesine tıklandı
    When kullanıcı login işlemi yaptı
    And kullanıcı ürünler sayfasına girer
    And kullanıcı isme göre ürün arar
    And kullanıcı aradığı ürüne tıklar
    And kullanıcı aradığı ürün hakkında soru sorar
    Then uygulama kapatıldı
