class Komoot : Service("Komoot", listOf("SRT", "Welsh Mountain", "Oaks to Philly"))
{
    init
    {
        for(user in userList)
        {
            for(route in user.routeList)
            {
                route.routeList = route.routeList.map { user.userID.toString() + it + user.userID.toString() }.toMutableList()
            }
        }
    }
}