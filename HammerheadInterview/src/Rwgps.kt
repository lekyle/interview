
class Rwgps : Service("RWGPS", listOf("CVT", "Perkiomen", "Welsh Mountain"))
{
    init
    {
        for(user in userList)
        {
            for(route in user.routeList)
            {
                route.routeList = route.routeList.map { it + user.userID.toString() }.toMutableList()
            }
        }
    }
}