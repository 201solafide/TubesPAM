<h1 align="center"> DAFTAR GAME GRATIS </h1>
<p align="justify"> Aplikasi Android ini menyediakan pengguna dengan akses mudah ke daftar game-game menarik yang dapat dimainkan secara gratis. Memanfaatkan layanan API FreeToGame, pengguna dapat dengan cepat menemukan berbagai judul game berkualitas tanpa biaya. Dengan antarmuka yang intuitif dan user-friendly, pengguna dapat menjelajahi daftar game, membaca deskripsi singkat, dan menemukan tautan langsung untuk mengunduh atau memainkan game secara online. Dengan aplikasi ini, pengguna dapat menikmati pengalaman bermain game yang menyenangkan tanpa harus khawatir tentang biaya. </p>

<h2 align="center"> Video Penggunaan Aplikasi</h2>
<p>
  Untuk melihat video penggunaan aplikasi kami silahkan klik <a href="https://drive.google.com/file/d/1yXUwTcXsjyxCsBVNoI4mr5UglmpXvPwC/view?usp=sharing">link video</a> berikut
</p>
<h2 align="center"> Dowload Aplikasi</h2> 
<p>
  Untuk mendownload aplikasi kami silahkan klik <a href="https://drive.google.com/drive/folders/1K5O2sveL91REw3DQMKUvFgK37WEpUwGo">link drive</a> berikut
</p>    


<h2 align="center">Anggota Proyek</h2>
<ul style="list-style-type:none; text-align:center; padding:0;">
  <li>
    <h4>Attar Akram Abdillah - 121140013 (pengembang proyek)</h4>
  </li>
   <li>
    <h4>Solafide Zamili - 121140201 (pengembang proyek)</h4>
  </li>
  <li>
    <h4>Nasrul Alfin Prassetyo - 121140001 (pengujian dan dokumentasi)</h4>
  </li>
  <li>
    <h4>Winnerson Laia - 121140121 (penguji dan dokumentasi)</h4>
  </li>
  <li>
    <h4>Muhammad Faried Halim - 121140197 (pengujian dan dokumentasi)</h4>
  </li>
</ul>

<h2 align="center">  BAB I : System Strukture </h2>
<p align="justify"> Tech Stack yang akan digunakan dalam aplikasi ini termasuk arsitektur MVVM untuk memisahkan antara model, tampilan, dan logika pemrosesan data. Aplikasi akan ditargetkan untuk SDK 34 dari Android. Basis data lokal akan dikelola menggunakan Room DB, sementara Retrofit akan digunakan untuk berkomunikasi dengan layanan API FreeToGame. Interceptor HTTP akan dipasang dengan Chucker untuk memantau dan mencatat panggilan API. Navigasi antar-fragmen akan dikelola menggunakan komponen Navigation, dan komponen Paging2 atau Paging3 akan digunakan untuk mengimplementasikan paginasi dalam daftar game.</p>		
<h3 align="center"> 1.1 Entity Relationship Diagram (ERD) </h3>
<p align="center">
  <img src="https://github.com/attarakram121140013/Tugas-Besar-PAM-Aplikasi-Rekomendasi-Game-Gratis/assets/96344530/27e36a83-ba64-46dc-b575-e8731b3c2373" alt="ERD" width="600">
</p>

<h3 align="center"> 1.2 Sequence Diagram </h3>
<p align="center">
  <img src="https://github.com/attarakram121140013/Tugas-Besar-PAM-Aplikasi-Rekomendasi-Game-Gratis/assets/96344530/74a9d9fc-992b-4138-99d8-c3d8bef2f9b3" alt="Sequence Diagram" width="600">
</p>

<h3 align="center"> 1.3 Class Diagram </h3>
<p align="center">
  <img src="https://github.com/attarakram121140013/Tugas-Besar-PAM-Aplikasi-Rekomendasi-Game-Gratis/assets/96344530/57f861e7-1465-40f4-95bd-d7eba59bbf8b" alt="Class Diagram" width="600">
</p>

<h3 align="center"> 1.4 Desain </h3>
<p align="center">
  <a href="https://www.figma.com/file/YjxT3uiYV3rpXhAW8vc8Yn/Tugas-Besar-Pengembangan-Aplikasi-Mobile-R---03?type=design&mode=design&t=mwpzdenIHItqEs5O-0">Link ke Desain Figma</a>
</p>
<p align="center">Di dalam desain kami, kami memiliki beberapa layer:</p>
<div align="center">
  </div>
  <ol style="text-align: left;">
    <li>splashscreen</li>
    <li>sign in</li>
    <li>home</li>
    <li>profil</li>
    <li>favorit</li>
    <li>search</li>
    <li>detail game</li>
  </ol>

<h2 align="center"> Bab II: Penjelasan Fitur Aplikasi </h2>

Berikut adalah versi yang telah diperbaiki dengan gambar yang benar dirujuk:

<h3>1. Splashscreen</h3>
Splashscreen adalah layar pertama yang muncul saat aplikasi dijalankan. Biasanya digunakan untuk menampilkan logo atau pesan selamat datang sementara aplikasi memuat.
<p align="center">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/d8371afa-d68d-489c-882e-8936cfacf3d7" alt="Splashscreen" width="300">
</p>
<h3>2. Sign In</h3>
Fitur Sign In memungkinkan pengguna untuk masuk ke dalam aplikasi dengan menggunakan kredensial yang telah terdaftar, seperti email dan password atau metode autentikasi lainnya.
<p align="center">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/2fa08b38-fc56-46bf-915c-8d100d9ecaee" alt="Sign In" width="300">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/6e99a6e0-0c5e-4280-96c9-44484c27eece" alt="Sign In" width="300">
</p>
<h3>3. Home</h3>
Home adalah layar utama aplikasi yang menampilkan konten utama atau informasi yang relevan bagi pengguna. Ini bisa berupa berita terbaru, tampilan game, atau konten yang disesuaikan.
<p align="center">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/f6589a83-7059-4ef2-b4b0-c17bf26fdbd1" alt="Home" width="300">
</p>
<h3>4. Profil</h3>
Fitur Profil memungkinkan pengguna untuk melihat dan mengelola informasi pribadi mereka. Pengguna dapat mengubah foto profil, mengedit informasi kontak, atau mengatur preferensi pengguna.
<p align="center">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/ba1dc408-f5f7-486a-8167-af26f4c5ff0f" alt="Profil" width="300">
</p>
<h3>5. Favorit</h3>
Fitur Favorit memungkinkan pengguna untuk menandai atau menyimpan item yang mereka sukai atau ingin simpan untuk akses cepat di kemudian hari, seperti game favorit atau konten lainnya.
<p align="center">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/01ac371e-fd55-4319-85e9-2667e43dfaf2" alt="Favorit" width="300">
</p>
<h3>6. Search</h3>
Fitur Search memungkinkan pengguna untuk mencari konten dalam aplikasi, seperti game, pengguna lain, atau informasi lainnya berdasarkan kriteria tertentu.
<p align="center">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/ba1dc408-f5f7-486a-8167-af26f4c5ff0f" alt="Search" width="300">
</p>
<h3>7. Detail Game</h3>
Fitur Detail Game menyediakan informasi lengkap tentang suatu game, termasuk deskripsi, gambar, ulasan, dan informasi terkait lainnya. Pengguna dapat melihat detail ini sebelum memutuskan untuk memainkan atau membeli game tersebut.
<p align="center">
  <img src="https://github.com/201solafide/TubesPAM/assets/96344530/80ded2b6-da85-478f-a46d-a5c797d6e63b" alt="Detail Game" width="300">
</p>

<h2>Bab III: Metode dan Penjelasan API</h2>

  <div class="method">
    <h3>Metode Waterfall</h3>
    <p>Kami menggunakan metode Waterfall dalam pengembangan aplikasi kami. Metode ini mengikuti alur kerja yang linear, dimulai dari perencanaan, analisis, desain, pengembangan, pengujian, hingga implementasi. Setiap tahap harus selesai sebelum memasuki tahap berikutnya.</p>
<p align="center">
  <img src="https://github.com/attarakram121140013/Tugas-Besar-PAM-Aplikasi-Rekomendasi-Game-Gratis/assets/96344530/446d368c-bb2e-4696-afa5-ad582c3a9a66" width="600" alt="Waterfall">
</p>


  </div>

  <div class="api">
    <h2>Bab IV: API yang Kami Gunakan</h2>
    <p>Berikut adalah API yang kami gunakan untuk aplikasi kami:</p>
    <ul>
      <li><a href="https://www.freetogame.com/api-doc">FreeToGame API</a>: API ini menyediakan data tentang game gratis.</li>
    </ul>


