import java.lang.IllegalArgumentException

class Services : IServices
{

    val strava = Strava()
    val rwgps = Rwgps()
    val komoot = Komoot()

    override fun getAllRoutes() : List<String>
    {
        val list = mutableListOf<String>()
        list.addAll(strava.getAllRoutes())
        list.addAll(rwgps.getAllRoutes())
        list.addAll(komoot.getAllRoutes())
        return list
    }

    override fun getUniqueRoutes() : List<String>
    {
        return getAllRoutes().distinct()
    }

    override fun getAllUserRoutes(userID: Int) : List<String>
    {
        val list = mutableListOf<String>()
        list.addAll(strava.getAllUserRoutes(userID))
        list.addAll(rwgps.getAllUserRoutes(userID))
        list.addAll(komoot.getAllUserRoutes(userID))
        return list
    }

    override fun getRoutesbyService(userID: Int, serviceList: List<String>) : List<String>
    {
        val list = mutableListOf<String>()
        for(service in serviceList)
        {
            when(service)
            {
                "Strava" -> list.addAll(strava.getAllUserRoutes(userID))
                "RWGPS" -> list.addAll(rwgps.getAllUserRoutes(userID))
                "Komoot" -> list.addAll(komoot.getAllUserRoutes(userID))
                else -> errorResponse("No such service.")
            }
        }
        return list
    }

    override fun errorResponse(msg:String): Nothing
    {
        throw IllegalArgumentException(msg)
    }
}