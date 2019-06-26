import kotlin.random.Random
import kotlin.system.measureTimeMillis

fun main()
{
        println(measureTimeMillis {
            val services = Services()
            println("Komoot's user list: " + services.komoot.userList.toString())
            println()
            println("Strava's user list " + services.strava.userList.toString())
            println()
            println("RWGPS's user list " + services.rwgps.userList.toString())
            println()

            println("All routes: " + services.getAllRoutes().toString())



            println("Unique routes: " + services.getUniqueRoutes().toString())
            println()

            val list = mutableListOf("Strava", "Komoot")
            for (i in 1..5)
            {
                val rng = Random.nextInt(1, 100)
                println("For user $rng: " + services.getAllUserRoutes(rng))
                println("For user $rng services $list: " + services.getRoutesbyService(rng, list))
                println()
            }
        }.toString() + " milliseconds to complete.")
}