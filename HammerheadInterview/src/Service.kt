import kotlin.random.Random

open class Service(private val service : String, private val routes : List<String>)
{
    val userList: List<User>

    init //generates a random list of users
    {
            userList = List(Random.nextInt(1,100)){genUser()}
    }

    fun getAllRoutes() : List<String>
    {
        return routes
    }

    fun getAllUserRoutes(userID: Int): List<String>
    {
        val list = mutableListOf<String>()
        for(user in userList)
        {
            if(user.userID == userID)
            {
                for(route in user.routeList)
                {
                    list.addAll(route.routeList)
                }
                return list
            }
        }

        return list
    }

    private fun genUser() : User //generates a random user and adds three route lists to each user
    {
        val uid = Random.nextInt(1,100)
        val newUser = userList?.find{it.userID == uid} ?: User(uid)

        for(i in 1..3)
        {
            newUser.addRoute(genRoute(uid))
        }

        return newUser
    }

    private fun genRoute(id:Int) : Route //generates random routes for each user
    {
        val routeList = mutableListOf<String>()
        var dest = ""
        for(i in 1..4)
        {
            when(service)
            {
                "Strava" -> dest = id.toString() + routes.random()
                "RWGPS" -> dest = routes.random() + id.toString()
                "Komoot" -> dest = id.toString() + routes.random() + id.toString()
            }

            routeList.add(dest)
        }

        return Route(routeList)
    }
}