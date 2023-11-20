import kotlin.math.floor

open class CompteEprange(private var numero:String, private var solde:Double):Compte(numero,solde) {
    override fun calculerComission(): Int {
        return floor(solde *  .01).toInt()
    }

}