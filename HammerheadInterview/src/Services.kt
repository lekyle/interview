import java.lang.IllegalArgumentException

class Services(private val servicesList: List<Service>) : IServices
{
    override fun getAllRoutes() : List<String>
    {
        return listOf(servicesList.map { it.getAllRoutes() }).flatten().flatten()
    }

    override fun getUniqueRoutes() : List<String>
    {
        return getAllRoutes().distinct()
    }

    override fun getAllUserRoutes(userID: Int) : List<String>
    {
        return listOf(servicesList.map { it.getAllUserRoutes(userID)}).flatten().flatten()
    }

    override fun getRoutesbyService(userID: Int, sList: List<String>) : List<String>
    {
        val list = mutableListOf<String>()

        for(serviceStr in sList)
        {
            for(service in servicesList)
            {
                if(service.service == serviceStr)
                {
                    list.addAll(service.getAllUserRoutes(userID))
                }
            }
        }
        return list
    }

    override fun errorResponse(msg:String): Nothing
    {
        throw IllegalArgumentException(msg)
    }
}