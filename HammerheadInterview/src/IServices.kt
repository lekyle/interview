interface IServices {
    fun getAllRoutes() : List<String>
    fun getAllUserRoutes(userID: Int) : List<String>
    fun getUniqueRoutes() : List<String>
    fun getRoutesbyService(userID: Int, serviceList:List<String>) : List<String>
    fun errorResponse(msg: String)
}