# Tutorial APAP
## Authors
* **Jihan Alfiyyah Munajat** - *1906298935* - *A*
---
## Tutorial 5
### What I have learned today
> Mengetahui bagaimana penggunaan API dalam webservice, tapi masih agak bingung karna banyak yang harus di explore seperti syntax-syntax dari springboot yang baru digunakan.
1. Apa itu Postman? Apa kegunaannya?
> Postman merupaka **API Client** yang dapat digunakan untuk create, share, test, dan mendokumentasikan API yang digunakan dalam suatu web.
> Postman bekerja di sisi backend dan dapat membuat request dan response yang sesuai
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
> Anotasi @JsonProperty digunakan untuk mapping nama dari property menggunakan JSON keys dengan serialization dan deserialization, 
> sedangkan @JsonIgnoreProperties digunakan dari level class untuk menandakan property atau list dari properti yang diabaikan.
3. Apa kegunaan atribut WebClient?
>Web client merupakan interface sebagai main entry point dari suatu web request. WebClient juga dapat digunakan sebagai pengatur request dan response dari URL.
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
>ResponseEntity merupakan objek representasi dari keseluruhan HTTP response, termasuk headers, body, dan status code.
> Sedangkan, BindingResult merupakan general interface yang digunakan sebagai ekstensi dari error, menyetujui suatu Validator untuk diterapkan, dan menambah binding specific analysis dan model building

---
## Tutorial 4 
### What I have learned today
>Lebih mengerti penerapan database, khususnya relasi many to many yang ditunjukkan antara Menu dan Cabang pada tutorial ini.
1. Jelaskan perbedaan th:include dan th:replace! 
> th:include memasukkan fragment ke dalam tag pada html yang dituju, sedangkan th:replace mengganti tag tersebut dengan fragment.
2. Jelaskan apa fungsi dari th:object! 
> th:object berguna untuk mempassing object dari html ke controller. Pada tutorial ini, th:object=’${cabang}’ pada form add cabang, menandakan bahwa seluruh data yang diterima dari form tersebut terikat pada object cabang.
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
> dalam penggunaan th:object, (*) bisa mengakses langsung attribute dari model tersebut karna terikat dengan objectnya. Sebagai contoh, th:object=’${cabang}’ yang dipassing adalah modelnya, dan untuk mengikat/mengakses noCabang, kita bisa langsung memanggil th:object=’*{noCabang}’ yang sudah terdefinisi ke model cabang yang sesuai.

---
## Tutorial 3
1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
> @AllArgsConstructor, @NoArgsConstructor, @Getter, @Setter merupakan anotasi dari project lombok. @AllArgsConstructor digunakan untuk
> secara otomatis mengenerate constructor dengan 1 parameter, sedangnakn @NoArgsConstructor tanpa parameter. @Setter digunakan untuk secara otomatis 
> mengenerate setter dalam class dan @getter mengenerate getter dalam class. @Entity digunakan untuk mengidentifikasi class tersebut menggunakan 
> data dari tabel database dan @Table akan menyesuaikan dengan nama tabel di database.
2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method
   tersebut?
>Method findByNoCabang digunakan untuk mengkustomisasi fungsionalitas atau menambahkan method custom ke database
3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
>@JoinTable memiliki availability untuk menggabungkan tabel yang tidak akan menggabungkan kolom jika nama kolom tersebut sama
> @JoinColumn memerlukan primary key dan foreign key yang akan digabungkan menjadi 1 kolom.
4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa
   kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
   perbedaan nullable dan penggunaan anotasi @NotNull
> Name merupakan kolom sebagai foreign key yang ada di tabel pegawai, referencedColumnName merujuk ke primary key di reference tabel yakni 
> tabel cabang. Nullable dalam anotasi mendefinisikan sebagai null constraint dalam table dari JPA repository, sedangkan @NotNull running BeanValidation
> untuk memvalidasi apakah attribute null atau tidak
5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
> FetchType.LAZY me-load database sesuai permintaan, sedangkan FetchType.EAGER akan selalu meload database setiap ada pemanggilan data. 
---
## Tutorial 2
### What I have learned today
Pada tutorial lab kali ini, saya mendapat pencerahan dari tutorial 1 terkait penggunaan @PathVariable dan @RequestParam, ternyata sejauh ini di ddp2 saya merasa saya baru mengimplementasikan @PathVariable. Selain itu juga ternyata di tutorial lab 2 ini juga mengimplementasikan dependency injection yakni dengan @AutoWired yang  ada pada Controller, dan mulai membuat operasi-operasi yang mulai melibatkan attribute-attribute pada object.

1. __Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi__
Yang muncul adalah Whitelabel Error Page dengan keterangan error dibawahnya. Saya pun melakukan tracing pada error, menghasilkan kesimpulan bahwa ini dikarenakan saya belum memiliki template pada project, padahal di controller sudah ada perintah untuk merender template tetapi thymeleaf belum bisa  merender template tersebut karena filenya belum ada. Hal ini lah yang menyebabkan menjadi error.


2. __Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat__
Autowired merupakan implementasi dari dependency injection, dimana cara kerjanya secara otomatis bekerja dengan melihat isi dari package pada aplikasi yang sedang berjalan, lalu mencari class yang memiliki anotasi seperti @Service.


3. __Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.__
Yang muncul adalah Whitelabel Error Page dengan keterangan error disebutkan bahwa dibutuhkan parameter noTelepon dengan tipe String tidak ditemukan. Hal ini karena parameter yang ada hanya 3 yakni id, namaKebunSafari, dan alamat, sedangkan yang dibutuhkan sebanyak 4 parameter termasuk noTelepon.

4. __Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?__
Sebenarnya untuk saat ini, Papa APAP belum bisa mencari Kebun Safari jika key yang digunakan adalah nama Kebun Safari, karena sejauh ini aplikasi hanya dapat mencari Kebun Safari dengan nomor ID Kebun Safarinya. Sejauh ini yang kita tahu, Papa APAP sudah terdaftar di list Kebun Safari dengan id 1, sehingga bisa dicari melalui link http://localhost:8080/kebun-safari?id=1 dan http://localhost:8080/kebun-safari/view/1. Untuk mencari dengan nama, mungkin saran yang bisa dilakukan adalah mendevelop fitur pencarian dengan nama Kebun Safari.

5. __Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.__
Yang ditampilkan adalah landing page yang berisi daftar seluruh Kebun Safari. Saya sudah menambahkan Kebun Safari yang lain, jadi [disini](https://ibb.co/9T8kxJz) terlihat ada 2 data Kebun Safari.

### What I did not understand
- [X] Sejauh ini masih amaan, cuma memang agak harus merefresh kembali operasi-operasi yang essensial yang dibutuhkan dalam Java, khususnya oop

---
## Tutorial 1
### What I have learned today
Pada tutorial kali ini, saya merasa seperti sedang dipacu adrenalin :D Dari teori-teori yang menjadi fundamental dari penggunaan Spring ini di kelas, hingga mulai mengaplikasikannya secara nyata. Hal ini masih terdengar asing ketika berbicara tentang _Spring_, _Maven_, bahkan ketika menggunakan Intellij pun saya masih kagok karna sebelumnya saya  menggunakan VSCode hehe. Tetapi dari tutorial kali ini saya cukup banyak mengeksplor mengenai istilah-istilah yang baru saya sebutkan. Dokumentasi tutorial yang sudah dibuat kakak asdos juga sangat baik, jadi semakin mudah untuk memahami tutorial 1 ini.

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
(Tuliskan jawabanmu)
Issue Tracker adalah tools yang terintegrasi dalam GitHub repository untuk mencatat yang sedang dikerjakan, ide untuk development, atau bahkan bugs dalam project, hal ini bisa dibedakan dengan tags yang tersedia (padakasus kali ini menggunakan tag enhancement). Di GitHub, issue tracker bisa digunakan untuk bertukar ide antar project team. Masalah yang dapat diselesaikan bisa dilihat dari manfaat Issue Tracker, yakni sistem pembuatan project lebih organized, tercatat dengan jelas setiap issue itu siapa yang bertanggung jawab, dan track issue akan selalu dapat diakses oleh timnya. 

2. Apa perbedaan dari git merge dan git merge --squash?
Git merge --squash akan menghilangkan commit yang berantakan menjadi 1 commit di git historynya. Git merge squash memiliki vulnerability yang cukup tinggi, terutama ketika di implementasi dalam project yang cukup besar, karena akan menghilangkan history dari setiap commit. Git merge akan merge setiap pull request yang masuk dengan mengabaikan segala commit yang sudah ada sebelumnya, ini lebih aman tetapi akan meninggalkan history yang terlalu banyak,

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi?
Dengan adanya version control system seperti ini, project team (khususnya developer) lebih mudah mentrack setiap progress dari project tersebut. Dengan adanya version control system, tim jadi lebih mudah dalam berkolaborasi, khususnya pada fitur yang disediakan oleh Git seperti Issue Tracker pada nomor 1.


### Spring
4. Apa itu library & dependency?
Kalau kita bisa membayangkan suatu diagram UML yang terdiri dari object dan relation, library bisa dianalogikan sebagai object dan dependency sebagai relation. Suatu library bisa menjadi dependency ketika project tersebut menggunakan library yang berkaitan, bisa dibilang library tersebut merupakan dependency dari project itu sendiri.

5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah software project management dan automation tool untuk proyek Java, berbasis POM (Project object model). Maven bukan merupakan framework sperti Django yang sudah kita pelajari di mata kuliah PPW, melainkan suatu build system yang bisa membuat application, manage dependency, menjalankan test, membuat report project, dan masih banyak lagi.
Dengan menggunakan Maven, ada beberapa benefit yang bisa didapatkan yakni tidak perlu membuat project dari scratch karena maven sudah bisa otomasi pembuatan project, bisa menggunakan dependency dari Maven, Maven bisa memprovide informasi project seperti log document, dan unit test reports. Selain itu juga Spring merupakan low-cost dan flexible framework.n Alternatif yang bisa dipilih selain Maven ada Azure DevOps Server, Jenkins, CircleCI, Red Hat Ansible Automation Platform, dan Postman.

6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring
Framework?
Selain pengembangan we, spring framework juga bisa bisa digunakan untuk seluruh project Java. Spring Framework juga applicable untuk aplikasi yang menggunakan plain old Java objects (POJOs). Dilansir dari web resminya, Spring framework memiliki fitur untuk testing, data access dengan ORM dan DAO support, terintegrasi dengan email, scheduling, dan cache, serta memiliki dynamic language seperti Kotlin dan Groovy.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
Keduanya digunakan untuk mengekstrak sesuatu dari sistem request, yang membedakan adalah bentuk ekstraksi dari kedua anotasi tersebut. @RequestParam digunakan untuk mengekstrak parameter query, form, bahkan file dari request, sedangkan @PathVariable mengekstrak value dari URI path. Response yang diberikan juga akan berbeda, url dengan @RequestParam akan menghasilkan url berupa string valuenya yang diencode, sedangkan @PathVariables akan menghasilkan url dengan ‘<variable>=<value>’ yang tidak di encode

### What I did not understand
- [X] Teori yang dipelajari masih agak belum terbayang implementasinya seperti apa
---
