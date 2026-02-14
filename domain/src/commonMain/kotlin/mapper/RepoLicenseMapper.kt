package mapper

import entity.RepoLicenseEntity
import response.RepoLicenseResponse

fun RepoLicenseResponse.toEntity(): RepoLicenseEntity {
    return RepoLicenseEntity(
        key = this.key.orEmpty(),
        name = this.name.orEmpty(),
        spdxId = this.spdxId.orEmpty(),
        url = this.url.orEmpty(),
        nodeId = this.nodeId.orEmpty()
    )
}