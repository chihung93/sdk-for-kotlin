package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import java.io.File

class Storage : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List buckets
     *
     * Get a list of all the storage buckets. You can use the query params to
     * filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: enabled, name, fileSecurity, maximumFileSize, encryption, antivirus
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.BucketList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listBuckets(
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.BucketList {
        val path = "/storage/buckets"
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.BucketList = {
            io.appwrite.models.BucketList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.BucketList::class.java,
            converter,
        )
    }
    
    /**
     * Create bucket
     *
     * Create a new storage bucket.
     *
     * @param bucketId Unique Id. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Bucket name
     * @param permissions An array of permission strings. By default no user is granted with any permissions. [Learn more about permissions](/docs/permissions).
     * @param fileSecurity Enables configuring permissions for individual file. A user needs one of file or bucket level permissions to access a file. [Learn more about permissions](/docs/permissions).
     * @param enabled Is bucket enabled?
     * @param maximumFileSize Maximum file size allowed in bytes. Maximum allowed value is 30MB. For self-hosted setups you can change the max limit by changing the `_APP_STORAGE_LIMIT` environment variable. [Learn more about storage environment variables](docs/environment-variables#storage)
     * @param allowedFileExtensions Allowed file extensions. Maximum of 100 extensions are allowed, each 64 characters long.
     * @param compression Compression algorithm choosen for compression. Can be one of none,  [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd), For file size above 20MB compression is skipped even if it's enabled
     * @param encryption Is encryption enabled? For file size above 20MB encryption is skipped even if it's enabled
     * @param antivirus Is virus scanning enabled? For file size above 20MB AntiVirus scanning is skipped even if it's enabled
     * @return [io.appwrite.models.Bucket]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBucket(
		bucketId: String,
		name: String,
		permissions: List<String>? = null,
		fileSecurity: Boolean? = null,
		enabled: Boolean? = null,
		maximumFileSize: Long? = null,
		allowedFileExtensions: List<String>? = null,
		compression: String? = null,
		encryption: Boolean? = null,
		antivirus: Boolean? = null
	): io.appwrite.models.Bucket {
        val path = "/storage/buckets"
        val params = mutableMapOf<String, Any?>(
            "bucketId" to bucketId,
            "name" to name,
            "permissions" to permissions,
            "fileSecurity" to fileSecurity,
            "enabled" to enabled,
            "maximumFileSize" to maximumFileSize,
            "allowedFileExtensions" to allowedFileExtensions,
            "compression" to compression,
            "encryption" to encryption,
            "antivirus" to antivirus
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Bucket = {
            io.appwrite.models.Bucket.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Bucket::class.java,
            converter,
        )
    }
    
    /**
     * Get Bucket
     *
     * Get a storage bucket by its unique ID. This endpoint response returns a
     * JSON object with the storage bucket metadata.
     *
     * @param bucketId Bucket unique ID.
     * @return [io.appwrite.models.Bucket]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getBucket(
		bucketId: String
	): io.appwrite.models.Bucket {
        val path = "/storage/buckets/{bucketId}".replace("{bucketId}", bucketId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Bucket = {
            io.appwrite.models.Bucket.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Bucket::class.java,
            converter,
        )
    }
    
    /**
     * Update Bucket
     *
     * Update a storage bucket by its unique ID.
     *
     * @param bucketId Bucket unique ID.
     * @param name Bucket name
     * @param permissions An array of permission strings. By default the current permissions are inherited. [Learn more about permissions](/docs/permissions).
     * @param fileSecurity Enables configuring permissions for individual file. A user needs one of file or bucket level permissions to access a file. [Learn more about permissions](/docs/permissions).
     * @param enabled Is bucket enabled?
     * @param maximumFileSize Maximum file size allowed in bytes. Maximum allowed value is 30MB. For self hosted version you can change the limit by changing _APP_STORAGE_LIMIT environment variable. [Learn more about storage environment variables](docs/environment-variables#storage)
     * @param allowedFileExtensions Allowed file extensions. Maximum of 100 extensions are allowed, each 64 characters long.
     * @param compression Compression algorithm choosen for compression. Can be one of none, [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd), For file size above 20MB compression is skipped even if it's enabled
     * @param encryption Is encryption enabled? For file size above 20MB encryption is skipped even if it's enabled
     * @param antivirus Is virus scanning enabled? For file size above 20MB AntiVirus scanning is skipped even if it's enabled
     * @return [io.appwrite.models.Bucket]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateBucket(
		bucketId: String,
		name: String,
		permissions: List<String>? = null,
		fileSecurity: Boolean? = null,
		enabled: Boolean? = null,
		maximumFileSize: Long? = null,
		allowedFileExtensions: List<String>? = null,
		compression: String? = null,
		encryption: Boolean? = null,
		antivirus: Boolean? = null
	): io.appwrite.models.Bucket {
        val path = "/storage/buckets/{bucketId}".replace("{bucketId}", bucketId)
        val params = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
            "fileSecurity" to fileSecurity,
            "enabled" to enabled,
            "maximumFileSize" to maximumFileSize,
            "allowedFileExtensions" to allowedFileExtensions,
            "compression" to compression,
            "encryption" to encryption,
            "antivirus" to antivirus
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Bucket = {
            io.appwrite.models.Bucket.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Bucket::class.java,
            converter,
        )
    }
    
    /**
     * Delete Bucket
     *
     * Delete a storage bucket by its unique ID.
     *
     * @param bucketId Bucket unique ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteBucket(
		bucketId: String
	): Any {
        val path = "/storage/buckets/{bucketId}".replace("{bucketId}", bucketId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * List Files
     *
     * Get a list of all the user files. You can use the query params to filter
     * your results. On admin mode, this endpoint will return a list of all of the
     * project's files. [Learn more about different API modes](/docs/admin).
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, signature, mimeType, sizeOriginal, chunksTotal, chunksUploaded
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.FileList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listFiles(
		bucketId: String,
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.FileList {
        val path = "/storage/buckets/{bucketId}/files".replace("{bucketId}", bucketId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.FileList = {
            io.appwrite.models.FileList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.FileList::class.java,
            converter,
        )
    }
    
    /**
     * Create File
     *
     * Create a new file. Before using this route, you should create a new bucket
     * resource using either a [server
     * integration](/docs/server/storage#storageCreateBucket) API or directly from
     * your Appwrite console.
     * 
     * Larger files should be uploaded using multiple requests with the
     * [content-range](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Range)
     * header to send a partial request with a maximum supported chunk of `5MB`.
     * The `content-range` header values should always be in bytes.
     * 
     * When the first request is sent, the server will return the **File** object,
     * and the subsequent part request must include the file's **id** in
     * `x-appwrite-id` header to allow the server to know that the partial upload
     * is for the existing file and not for a new one.
     * 
     * If you're creating a new file using one of the Appwrite SDKs, all the
     * chunking logic will be managed by the SDK internally.
     * 
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID. Choose your own unique ID or pass the string "unique()" to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param file Binary file.
     * @param permissions An array of permission strings. By default the current user is granted with all permissions. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFile(
		bucketId: String,
		fileId: String,
		file: InputFile,
		permissions: List<String>? = null, onProgress: ((UploadProgress) -> Unit)? = null
	): io.appwrite.models.File {
        val path = "/storage/buckets/{bucketId}/files".replace("{bucketId}", bucketId)
        val params = mutableMapOf<String, Any?>(
            "fileId" to fileId,
            "file" to file,
            "permissions" to permissions
        )
        val headers = mutableMapOf(
            "content-type" to "multipart/form-data"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        val idParamName: String? = "fileId"
        val paramName = "file"
        return client.chunkedUpload(
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            converter,
            paramName,
            idParamName,
            onProgress,
        )
    }
    
    /**
     * Get File
     *
     * Get a file by its unique ID. This endpoint response returns a JSON object
     * with the file metadata.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFile(
		bucketId: String,
		fileId: String
	): io.appwrite.models.File {
        val path = "/storage/buckets/{bucketId}/files/{fileId}".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            converter,
        )
    }
    
    /**
     * Update File
     *
     * Update a file by its unique ID. Only users with write permissions have
     * access to update this resource.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param permissions An array of permission string. By default the current permissions are inherited. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.File]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateFile(
		bucketId: String,
		fileId: String,
		permissions: List<String>? = null
	): io.appwrite.models.File {
        val path = "/storage/buckets/{bucketId}/files/{fileId}".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "permissions" to permissions
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.File = {
            io.appwrite.models.File.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.File::class.java,
            converter,
        )
    }
    
    /**
     * Delete File
     *
     * Delete a file by its unique ID. Only users with write permissions have
     * access to delete this resource.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteFile(
		bucketId: String,
		fileId: String
	): Any {
        val path = "/storage/buckets/{bucketId}/files/{fileId}".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Get File for Download
     *
     * Get a file content by its unique ID. The endpoint response return with a
     * 'Content-Disposition: attachment' header that tells the browser to start
     * downloading the file to user downloads directory.
     *
     * @param bucketId Storage bucket ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFileDownload(
		bucketId: String,
		fileId: String
	): ByteArray {
        val path = "/storage/buckets/{bucketId}/files/{fileId}/download".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
            "key" to client.config["key"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get File Preview
     *
     * Get a file preview image. Currently, this method supports preview for image
     * files (jpg, png, and gif), other supported formats, like pdf, docs, slides,
     * and spreadsheets, will return the file icon image. You can also pass query
     * string arguments for cutting and resizing your preview image. Preview is
     * supported only for image files smaller than 10MB.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID
     * @param width Resize preview image width, Pass an integer between 0 to 4000.
     * @param height Resize preview image height, Pass an integer between 0 to 4000.
     * @param gravity Image crop gravity. Can be one of center,top-left,top,top-right,left,right,bottom-left,bottom,bottom-right
     * @param quality Preview image quality. Pass an integer between 0 to 100. Defaults to 100.
     * @param borderWidth Preview image border in pixels. Pass an integer between 0 to 100. Defaults to 0.
     * @param borderColor Preview image border color. Use a valid HEX color, no # is needed for prefix.
     * @param borderRadius Preview image border radius in pixels. Pass an integer between 0 to 4000.
     * @param opacity Preview image opacity. Only works with images having an alpha channel (like png). Pass a number between 0 to 1.
     * @param rotation Preview image rotation in degrees. Pass an integer between -360 and 360.
     * @param background Preview image background color. Only works with transparent images (png). Use a valid HEX color, no # is needed for prefix.
     * @param output Output format type (jpeg, jpg, png, gif and webp).
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFilePreview(
		bucketId: String,
		fileId: String,
		width: Long? = null,
		height: Long? = null,
		gravity: String? = null,
		quality: Long? = null,
		borderWidth: Long? = null,
		borderColor: String? = null,
		borderRadius: Long? = null,
		opacity: Double? = null,
		rotation: Long? = null,
		background: String? = null,
		output: String? = null
	): ByteArray {
        val path = "/storage/buckets/{bucketId}/files/{fileId}/preview".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "width" to width,
            "height" to height,
            "gravity" to gravity,
            "quality" to quality,
            "borderWidth" to borderWidth,
            "borderColor" to borderColor,
            "borderRadius" to borderRadius,
            "opacity" to opacity,
            "rotation" to rotation,
            "background" to background,
            "output" to output,
            "project" to client.config["project"],
            "key" to client.config["key"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
    /**
     * Get File for View
     *
     * Get a file content by its unique ID. This endpoint is similar to the
     * download method but returns with no  'Content-Disposition: attachment'
     * header.
     *
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @return [ByteArray]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getFileView(
		bucketId: String,
		fileId: String
	): ByteArray {
        val path = "/storage/buckets/{bucketId}/files/{fileId}/view".replace("{bucketId}", bucketId).replace("{fileId}", fileId)
        val params = mutableMapOf<String, Any?>(
            "project" to client.config["project"],
            "key" to client.config["key"]
        )
        return client.call(
            "GET",
            path,
            params = params,
            responseType = ByteArray::class.java
        )
    }
    
}
