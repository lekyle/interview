import java.lang.IllegalArgumentException

class Services : IServices
{
    val strava = Strava()
    val rwgps = Rwgps()
    val komoot = Komoot()

    override fun getAllRoutes() : List<String>
    {
        return listOf(strava.getAllRoutes(), rwgps.getAllRoutes(), komoot.getAllRoutes()).flatten()
    }

    override fun getUniqueRoutes() : List<String>
    {
        return getAllRoutes().distinct()
    }

    override fun getAllUserRoutes(userID: Int) : List<String>
    {
        return listOf(strava.getAllUserRoutes(userID), rwgps.getAllUserRoutes(userID), komoot.getAllUserRoutes(userID)).flatten()
    }

    override fun getRoutesbyService(userID: Int, serviceList: List<String>) : List<String>
    {
        val list = mutableListOf<String>()

        serviceList.map { when(it)
        {
            "Strava" -> list.addAll(strava.getAllUserRoutes(userID))
            "RWGPS" -> list.addAll(rwgps.getAllUserRoutes(userID))
            "Komoot" -> list.addAll(komoot.getAllUserRoutes(userID))
            else -> errorResponse("No such service.")
        } }

        return list
    }

    override fun errorResponse(msg:String): Nothing
    {
        throw IllegalArgumentException(msg)
    }
}