import kotlin.math.floor

class CompteEpragneVip(private var numero:String, private var solde:Double):CompteEprange(numero,solde) {
    override fun calculerComission(): Int {
        return floor(solde *  .02).toInt()
    }

}