data class User(val userID: Int)
{
    val routeList = mutableListOf<Route>()

    fun addRoute(route: Route)
    {
        routeList.add(route)
    }
}