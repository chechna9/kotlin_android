fun main(args: Array<String>) {
    // Création d'une liste contenant différents types de comptes
    val listeComptes = listOf<Compte>(
        CompteEprange("eo0005",1000.0 ),
        CompteEpragneVip("epV1",1500.0),
        CompteDevise("dv001",2000.0,  1.5)
    )

    // Calcul de la commission totale pour tous les comptes
    var commissionTotale = 0.0
    for (compte in listeComptes) {
        commissionTotale += compte.calculerComission()
    }

    // Affichage de la commission totale
    println("Commission totale pour tous les comptes : $commissionTotale")
}