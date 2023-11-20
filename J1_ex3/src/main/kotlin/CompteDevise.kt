import kotlin.math.floor

class CompteDevise(private var numero:String,private var solde:Double,var taux:Double):Compte(numero,solde) {
    override fun calculerComission(): Int {
       return floor(solde * taux * .02).toInt()
    }
}