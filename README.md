# Tutorial APAP
## Authors
* **Jihan Alfiyyah Munajat** - *1906298935* - *A*
---
## Tutorial 8
### What I have learned today
Saya lagi mencoba untuk belajar pasrah :D

### Pertanyaan
#### 1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
> Untuk memecahkan soal latihan no. 1, saya cukup mengatur state (`setState`) title, price, description, category, dan quantity menjadi nilai default. Hal ini dilakukan agar text field pada form add resep menjadi kosong setiap kali pengguna ingin menambahkan resep baru.

#### 2. Jelaskan fungsi dari async dan await!
> `async`/`await` merupakan sebuah syntax khusus yang digunakan untuk bekerja dengan Promise agar lebih nyaman dan mudah untuk digunakan. `async` digunakan untuk mengubah function menjadi asynchronous (bersifat non-blocking). Fungsi `async` akan mengembalikan sebuah Promise. Sedangkan, `await` merupakan fungsi yang hanya berjalan di dalam `async`. `await` berfungsi untuk menunda sebuah kode dijalankan sampai proses `async` berhasil. `await` juga akan mengembalikan Promise, namun kode yang pada fungsi `await` ini baru dapat dijalankan ketika Promise sudah resolved.

#### 3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle pada pertanyaan ini.
<img src="https://i.postimg.cc/3JYjnThN/message-Image-1638378026813.jpg"></img> <br>
#### 4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
- `componentDidMount`: Fungsi ini dipanggil setelah component telah selesai di-render untuk menjalankan perintah seperti fetch data. Contoh use case yang menggunakan fungsi ini adalah saat kita ingin mengubah value pada suatu state setelah di-render selama beberapa detik. <br>
- `shouldComponentUpdate`: Fungsi ini dipanggil ketika terjadi perubahan pada state. Jika yang di-return bernilai true maka component akan di-render ulang terhadap perubahan itu. Namun, jika yang di-return bernilai false maka tidak dilakukan render ulang. Contoh use case yang menggunakan fungsi ini adalah saat kita ingin memberitahu React jika output component tidak terpengaruh oleh perubahan state atau props saat ini. <br>
- `componentDidUpdate`: Fungsi ini dipanggil setelah component yang diubah sudah selesai di-render. Contoh use case yang menggunakan fungsi ini adalah saat kita ingin menjalankan suatu fungsi setelah DOM berhasil diupdate. <br>
- `componentWillReceiveProps`: Fungsi ini dipanggil saat kita ingin menjalankan suatu kode sebelum component yang di-mount melakukan sesuatu terhadap props yang baru mengalami perubahan. Contoh use case yang menggunakan fungsi ini adalah saat kita ingin memeriksa apakah terdapat perubahan terhadap props dengan membandingkan props yang ada dengan yang baru. <br>
- `componentWillUnmount`: Fungsi ini dipanggil saat kita ingin menjalankan statement sebelum component dihapus dari DOM. Contoh use case yang menggunakan fungsi ini adalah saat kita  membatalkan network request atau menghilangkan event listener.<br>
---
## Tutorial 7
### What have I learned today
1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot
   sebagai ilustrasi dari apa yang Anda jelaskan.
> Untuk soal pertama terkait pembuatan fungsi delete item dari cart dengan hanya mengklik tombol delete (tempat sampah)
> yang didapatkan dari halaman tampilan keranjang pembelian. Saya membuat method handleDeleteItemInCart pada home dengan cara
> mengakses list cartitems, lalu memfilter list tersebut dengan item yang dipilih dan menyimpannya ke dalam variabel baru. 
> Setelah itu, list yang baru saya simpan ke state cart items. Berikut adalah codingannya
<img src="https://ibb.co/vc2d4Kg"></img><br>
> Untuk nomor 2 dan 3, saya mengubah di method handleAddItemToCart dengan membuat kondisi (if-else) didalamnya. Ketika kondisinya
> current balance dikurangi dengan harga barang yang dipilih menghasilkan negatif yang menandakan bahwa balance tidak cukup untuk memilih
> barang tersebut, saya akan menampilkan alert dan tidak mengeksekusi adanya penambahan item pada cart item. Ketika balance dinyatakan
> cukup, baru proses dieksekusi, juga dengan mengurangi balance yang dimiliki. Berikut adalah codingannya<br>
<img src="https://ibb.co/r5d0Mrd"></img><br>
2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
> State merupakan sebuah data yang private dari suatu komponen, sehingga tidak dapat diakses secara langsung apabila
> dipanggil dari komponen lain. Tetapi, state ini selalu berubah seiring berjalannya waktu. Adapun props sendiri merupakan 
> singkatan dari *properties* yang menyimpan argumen yang pertamakali diinput.
3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam React? sebutkan alasannya.
> Ya perlu, hal ini membantu kita untuk mengimplementasikan object dalam web sehingga komponen yang memiliki logic-nya sendiri 
> akan tetap konsisten ketika kita menggunakannya dimanapun. 
4. Apa perbedaan class component dan functional component?
> Functional component merupakan merender UI berdasarkan argument (props) yang diterima pertama kali, dan mereturn element. 
> Sedangkan class component merupakan ekstensi dari komponen yang diterima, seperti pengaturan state yang diterapkan pada web.
5. Dalam react, apakah perbedaan component dan element?
> Element merupakan hal yang dikembalikan (return) dari komponen, sedangkan component dalam react bisa merupakan function/class 

---
## Tutorial 6
### What I have learned today
> Mulai bisa mengerti Otentikasi dan Otorisasi pada website dengan libraru-library yang sudah disediakan. Hari ini juga saya menemukan beberapa masalah yang debugnya membutuhkan waktu sektiar 2 -3 jam. 
1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?
> Otentikasi merupakan aturan yang digunakan untuk mengecek apakah credential dari user valid atau tidak. Otentikasi akan mengecek username dan password yang di-input user ada (valid) atau tidak ada (tidak valid) di dalam users / credentials storage. Otentikasi diperlukan untuk mem-verifikasi bahwa pengguna mempunyai akses untuk masuk ke dalam sistem. Konsep otentikasi dalam kode yang telah saya buat diimplementasi pada class `WebSecurityConfig` bagian `.anyRequest().authenticated()` dan method `configAuthentication`.
> Sedangkan, otorisasi merupakan aturan yang digunakan untuk mengecek hak user berdasarkan role-nya. Hak yang dimaksud di sini adalah fungsi / fitur apa saja yang dapat dijalankan / diakses user. User harus telah lolos uji otentikasi terlebih dahulu untuk dapat diuji otorisasinya. Konsep otorisasi dalam kode yang telah saya buat diimplementasi pada class `UserDetailsServiceImpl` dan juga pada class `WebSecurityConfig` bagian `.antMatchers("/menu/add/**").hasAnyAuthority("Manajer")` dan `.antMatchers("/user/delete/**").hasAnyAuthority("Admin")`

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
> Spring Security menyediakan BCryptPasswordEncoder untuk untuk menyandikan (encode) password. Class yang merupakan implementasi dari PasswordEncoder ini menggunakan fungsi hashing (algoritma) BCript yang kuat. Credentials user baru disimpan dan password akan dienkripsi menggunakan `BCryptPasswordEncoder` sehingga pada database tersimpan password yang telah dienkripsi secara otomatis.
3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa demikian?
> Hashing atau encryption sebenarnya keduanya digunakan agar menghindari kebobolan keamanan pada akun yang terdaftar. Kedua proses ini dibedakan dari tekniknya, dimana encryption merupakan proses 2 arah enkripsi yang dapat di encode dan decode melalui matching keys, sedangkan hashing merupakan teknik enkripsi 1 arah. Maka dari itu, untuk menyimpan password sebaiknya menggunakan hashing karena kemungkinan didecodenya lebih kecil, bahkan impossible.
4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
>UUID (Universally Unique Identifier) merepresentasikan suatu nilai `Long` 128-bit yang unik untuk segala tujuan praktis yang di-generate secara random oleh sistem. Standardnya, representasi UUID menggunakan digit hex (oktet). Ini digunakan untuk mengidentifikasi informasi yang harus unik dalam suatu sistem. Penggunaan UUID pada tutorial kali ini terdapat pada id user dalam UserModel.
5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserRoleServiceImpl.java?
> Class `UserDetailsServiceImpl` dapat memuat user's credentials termasuk username, password, dan role yang dapat memudahkan untuk proses Otorisasi. Class ini juga difokuskan untuk menentukan hak-hak yang dimiliki user, termasuk role yang dimilikinya.

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
> th:object berguna untuk mempassing object dari html ke controller. Pada tutorial ini, th:object=???${cabang}??? pada form add cabang, menandakan bahwa seluruh data yang diterima dari form tersebut terikat pada object cabang.
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
> dalam penggunaan th:object, (*) bisa mengakses langsung attribute dari model tersebut karna terikat dengan objectnya. Sebagai contoh, th:object=???${cabang}??? yang dipassing adalah modelnya, dan untuk mengikat/mengakses noCabang, kita bisa langsung memanggil th:object=???*{noCabang}??? yang sudah terdefinisi ke model cabang yang sesuai.

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
Keduanya digunakan untuk mengekstrak sesuatu dari sistem request, yang membedakan adalah bentuk ekstraksi dari kedua anotasi tersebut. @RequestParam digunakan untuk mengekstrak parameter query, form, bahkan file dari request, sedangkan @PathVariable mengekstrak value dari URI path. Response yang diberikan juga akan berbeda, url dengan @RequestParam akan menghasilkan url berupa string valuenya yang diencode, sedangkan @PathVariables akan menghasilkan url dengan ???<variable>=<value>??? yang tidak di encode

### What I did not understand
- [X] Teori yang dipelajari masih agak belum terbayang implementasinya seperti apa
---
