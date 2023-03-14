## İnsan Kaynakları Projesi:

Not: Aşağıdaki gereksinimlere göre ui(thymeleaf,react veya angular) sayfa yapalım.

+ Roller: Admin(insan kaynakları) user(çalışanlar)
+ Database relation: admin(1) - user (N) ==> Spring Data(@OneToMany @ManyToOne ilişki üzerinde olmalıdır)
+ Register/Login: Eğer kullanıcı üye değilse üye olması gerekiyor şifreler database maskelenmiş şekilde kaydedilmelidir. (Spring Security)
+ Tanımlama: Çalışanlar şifresini girerek sisteme giriş yapar. (Login için 3 giriş hakkı vardır yoksa bloke olur)
+ İnsan kaynakları her bir çalışan bilgisine erişebilmelidir.
+ Hangi çalışana ne kadar maaş veriliyor bilgisine v.b erişim sağlamalıdır.
+ Hangi çalışanının hangi gün izin verildiği bilgisine erişim sağlaması gerekiyor.
+ Loglama: Yapılan her bir işlem için mutlaka loglama tutmak gerekiyor

Dikkat:

+ OOP kullanmak çok önemli(interface,abstract,inheritance) , Stream API,Optional,enum kullanılmalıdır.
+ Design pattern kullanmalıyız.
+ Clean code mantığında ilerlemeliyiz
+ S.O.L.I.D prensibine uygun kodlar yazmalıyız.

## Katmanlar
Projenin Katmanları

### Modeller
Projenin varlıkları ve dto'ları bu pakettedir. Bu varlıklar ayrıca veritabanındaki bir tabloyu temsil eder.

### Dao
Projenin Veri Erişim Katmanı. Projedeki tüm depolar bu pakette.
Her varlık için JpaRepository'yi Spring Data Jpa'dan genişleten bir arayüz vardır.

### Hizmetler
Projenin İş Katmanı. Servis arayüzleri ve yönetici sınıfları bu klasördedir.
Bu pakette projenin iş kodları yazılır.

### Denetleyiciler
Bu paket, projeyi internette api olarak yayınlayan tüm rest controller sınıflarına sahiptir.

### Güvenlik
Spring Security için gerekli olan yapılandırma sınıfları. Kimlik doğrulama ve yetkilendirme işlemleri burada yazılır.
Ve JWT belirteci bu pakette oluşturulur ve doğrulanır.