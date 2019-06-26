import kotlin.random.Random

open class Service(val service : String, private val routes : List<String>)
{
    var userList: List<User>

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
        val userID = Random.nextInt(1,100)
        val newUser = userList?.find{it.userID == userID} ?: User(userID)

        for(i in 1..3)
        {
            newUser.addRoute(genRoute())
        }

        return newUser
    }

    private fun genRoute() : Route //generates random routes for each user
    {
        val routeList = mutableListOf<String>()
        for(i in 1..4)
        {
            routeList.add(routes.random())
        }

        return Route(routeList)
    }
}