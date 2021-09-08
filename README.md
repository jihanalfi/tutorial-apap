# Tutorial APAP
## Authors
* **Jihan Alfiyyah Munajat** - *1906298935* - *A*

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
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [X] Kenapa saya harus belajar APAP?
Karena pengaplikasian APAP untuk kedepannya pasti akan tetap dibutuhkan, selain itu juga pasti menjadi landasan untuk mata kuliah Propensi :D
---
