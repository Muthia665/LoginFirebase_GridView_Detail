package com.muzaaz.loginfirebasegridviewdetail

object Data {
    private val names = arrayOf(
        "Persegi",
        "Persegi Panjang",
        "Segitiga",
        "Jajar Genjang",
        "Trapesium",
        "Layang-Layang",
        "Belah Ketupat",
        "Lingkaran"
    )

    private val details = arrayOf(
        "L = S x S \n\n Keterangan : \n o> L = Luas \n o> S = Sisi \n\n\n K = S x S x S x S \n\n Keterangan \n o> K = Keliling \n o> S = Sisi",
        "L = P x L \n\n Keterangan : \n o> L = Luas \n o> P = Panjang \n\n\n K = (2 x P) + (2 x L) \n\n Keterangan \n o> P = Panjang \n o> Luas",
        "L = 1 / 2 x a x t \n\n Keterangan : \n a = alas \n t = tinggi \n\n\n K = S x S x S  \n Keterangan \n o> Sisi",
        "L = a x t \n\n Keterangan : \n o> a = alas \n o> tinggi \n\n\n K : 2 x a + 2 x Sisi miringnya",
        "L = 1 / 2 x (Jumlah kedua sisi yang sejajar) x t \n\n Keterangan \n t = Tinggi \n\n\n K = S + S + S + S \n\n Keterangan : \n o> S = Sisi",
        "L = ½ x d1 x d2 \n\n Keterangan : \n o> d1 = diagonal vertikal \n o> d2 = diagonal horizontalo> d1 = diagonal vertikal \n o> d2 = diagonal horizontal \n\n\n 2 x (s1 + s2 ) \n\n keterangan : \n S = Sisi",
        "L = ½ x d1 x d2 \n\n Keterangan : \n o> d1 = diagonal vertikal \n o> d2 = diagonal horizontal \n\n\n K : 4 x S \n\n Keterangan : \n S = Sisi",
        "L = π x r x r \n\n keterangan : \n o> π = phi \n o> r = jari-jari Lingakaran"
    )

    private val photos = intArrayOf(
        R.drawable.persegi,
        R.drawable.persegi_panjang,
        R.drawable.segitiga,
        R.drawable.jajar_genjang,
        R.drawable.trapesium,
        R.drawable.layang_layang,
        R.drawable.belah_ketupat,
        R.drawable.lingkaran
    )

    val listData: ArrayList<Model>
        get() {
            val list = arrayListOf<Model>()
            for (position in names.indices) {
                val model = Model()
                model.name = names[position]
                model.detail = details[position]
                model.photo = photos[position]
                list.add(model)
            }
            return list
        }
}