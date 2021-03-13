package ao.fenixinovation.romavicdosanjos.app.data.repository

import ao.fenixinovation.romavicdosanjos.app.data.api.ApiClient
import ao.fenixinovation.romavicdosanjos.app.data.models.ModelsPhotosItem

class Repository(var apiClient: ApiClient) {

    suspend fun gePhotosRepository(): MutableList<ModelsPhotosItem> {
        return apiClient.gePhotosEndpoint()
    }

}