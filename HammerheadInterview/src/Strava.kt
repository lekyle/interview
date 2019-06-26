
class Strava:Service("Strava", listOf("SRT", "CVT", "Perkiomen"))
{
    init
    {
        for(user in userList)
        {
            for(route in user.routeList)
            {
                route.routeList = route.routeList.map { user.userID.toString() + it }.toMutableList()
            }
        }
    }
}
