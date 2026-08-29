fun main() {

    // Bai 1: Named parameter

    fun inThongTin(ten: String, tuoi: Int) {
        println("Ten: $ten")
        println("Tuoi: $tuoi")
    }

    inThongTin(ten = "Hai", tuoi = 20)

    /*
    Named parameter la cach truyen gia tri vao ham bang cach
    ghi ro ten cua tham so.

    Vi du:
    inThongTin(ten = "Hai", tuoi = 20)

    Neu khong ghi ten tham so ma chi truyen value thi cac gia tri
    se duoc truyen theo thu tu cua tham so trong ham.

    Vi du:
    inThongTin("Hai", 20)

    Khi do "Hai" duoc truyen vao ten va 20 duoc truyen vao tuoi.

    Neu ham tra ve gia tri la mot so nguyen thi them : Int
    sau phan khai bao tham so.

    Vi du:
    fun tong(a: Int, b: Int): Int {
        return a + b
    }

    Unit la kieu du lieu dai dien cho ham khong tra ve gia tri.
    */


    // Bai 2: Default parameter

    fun thongTin(ten: String, tuoi: Int = 20) {
        println("Ten: $ten")
        println("Tuoi: $tuoi")
    }

    thongTin("Hai")

    /*
    Ham co the co nhieu hon mot default parameter.

    Vi du:
    fun thongTin(ten: String = "Hai", tuoi: Int = 20) {
        println(ten)
        println(tuoi)
    }

    Default parameter khong nhat thiet phai la last parameter.

    Vi du:
    fun test(a: Int = 10, b: Int) {
        println(a)
        println(b)
    }

    Co the goi:
    test(b = 20)

    Khi do a se nhan gia tri mac dinh la 10,
    b nhan gia tri 20.
    */


    // Bai 3: Lambda

    val tong: (Int, Int) -> Int = { a, b ->
        a + b
    }

    println("Tong = ${tong(5, 10)}")

    /*
    Lambda tren nhan vao hai so nguyen va tra ve tong
    cua hai so do.

    Neu lambda chi co mot tham so thi khong can khai bao
    ten tham so, co the dung "it".

    Vi du:
    val binhPhuong: (Int) -> Int = { it * it }

    Khong nhat thiet phai viet return trong lambda.
    Gia tri cua bieu thuc cuoi cung se duoc tra ve.
    */


    // Bai 4: Trailing lambda syntax

    fun buildString(builderAction: StringBuilder.() -> Unit): String {
        val sb = StringBuilder()
        sb.builderAction()
        return sb.toString()
    }

    val result = buildString {
        append("Hello")
        append(" World")
    }

    println(result)

    /*
    Trailing lambda syntax la cach viet lambda ra ben ngoai
    dau ngoac khi lambda la tham so cuoi cung cua ham.

    Cach viet:
    val result = buildString {
        append("Hello")
        append(" World")
    }

    Nen de tham so lambda o cuoi danh sach tham so vi khi do
    co the su dung trailing lambda syntax.

    Cach viet nay ngan gon va de doc hon.
    */
}