package io.appwrite.services
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Databases : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Databases
     *
     * Get a list of all databases from the current Appwrite project. You can use
     * the search parameter to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.DatabaseList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.DatabaseList {
        val path = "/databases"
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.DatabaseList = {
            io.appwrite.models.DatabaseList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DatabaseList::class.java,
            converter,
        )
    }
    
    /**
     * Create Database
     *
     * Create a new Database.
     * 
     *
     * @param databaseId Unique Id. Choose your own unique ID or pass the string "unique()" to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @return [io.appwrite.models.Database]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
		databaseId: String,
		name: String
	): io.appwrite.models.Database {
        val path = "/databases"
        val params = mutableMapOf<String, Any?>(
            "databaseId" to databaseId,
            "name" to name
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Database = {
            io.appwrite.models.Database.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Database::class.java,
            converter,
        )
    }
    
    /**
     * Get Database
     *
     * Get a database by its unique ID. This endpoint response returns a JSON
     * object with the database metadata.
     *
     * @param databaseId Database ID.
     * @return [io.appwrite.models.Database]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(
		databaseId: String
	): io.appwrite.models.Database {
        val path = "/databases/{databaseId}".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Database = {
            io.appwrite.models.Database.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Database::class.java,
            converter,
        )
    }
    
    /**
     * Update Database
     *
     * Update a database by its unique ID.
     *
     * @param databaseId Database ID.
     * @param name Collection name. Max length: 128 chars.
     * @return [io.appwrite.models.Database]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
		databaseId: String,
		name: String
	): io.appwrite.models.Database {
        val path = "/databases/{databaseId}".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
            "name" to name
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Database = {
            io.appwrite.models.Database.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Database::class.java,
            converter,
        )
    }
    
    /**
     * Delete Database
     *
     * Delete a database by its unique ID. Only API keys with with databases.write
     * scope can delete a database.
     *
     * @param databaseId Database ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(
		databaseId: String
	): Any {
        val path = "/databases/{databaseId}".replace("{databaseId}", databaseId)
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
     * List Collections
     *
     * Get a list of all collections that belong to the provided databaseId. You
     * can use the search parameter to filter your results.
     *
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, documentSecurity
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.CollectionList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listCollections(
		databaseId: String,
		queries: List<String>? = null,
		search: String? = null
	): io.appwrite.models.CollectionList {
        val path = "/databases/{databaseId}/collections".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.CollectionList = {
            io.appwrite.models.CollectionList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.CollectionList::class.java,
            converter,
        )
    }
    
    /**
     * Create Collection
     *
     * Create a new Collection. Before using this route, you should create a new
     * database resource using either a [server
     * integration](/docs/server/databases#databasesCreateCollection) API or
     * directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Unique Id. Choose your own unique ID or pass the string "unique()" to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @param permissions An array of permissions strings. By default no user is granted with any permissions. [Learn more about permissions](/docs/permissions).
     * @param documentSecurity Enables configuring permissions for individual documents. A user needs one of document or collection level permissions to access a document. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createCollection(
		databaseId: String,
		collectionId: String,
		name: String,
		permissions: List<String>? = null,
		documentSecurity: Boolean? = null
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}/collections".replace("{databaseId}", databaseId)
        val params = mutableMapOf<String, Any?>(
            "collectionId" to collectionId,
            "name" to name,
            "permissions" to permissions,
            "documentSecurity" to documentSecurity
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Get Collection
     *
     * Get a collection by its unique ID. This endpoint response returns a JSON
     * object with the collection metadata.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getCollection(
		databaseId: String,
		collectionId: String
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}/collections/{collectionId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Update Collection
     *
     * Update a collection by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param name Collection name. Max length: 128 chars.
     * @param permissions An array of permission strings. By default the current permission are inherited. [Learn more about permissions](/docs/permissions).
     * @param documentSecurity Enables configuring permissions for individual documents. A user needs one of document or collection level permissions to access a document. [Learn more about permissions](/docs/permissions).
     * @param enabled Is collection enabled?
     * @return [io.appwrite.models.Collection]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateCollection(
		databaseId: String,
		collectionId: String,
		name: String,
		permissions: List<String>? = null,
		documentSecurity: Boolean? = null,
		enabled: Boolean? = null
	): io.appwrite.models.Collection {
        val path = "/databases/{databaseId}/collections/{collectionId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
            "documentSecurity" to documentSecurity,
            "enabled" to enabled
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Collection = {
            io.appwrite.models.Collection.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Collection::class.java,
            converter,
        )
    }
    
    /**
     * Delete Collection
     *
     * Delete a collection by its unique ID. Only users with write permissions
     * have access to delete this resource.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteCollection(
		databaseId: String,
		collectionId: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
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
     * List Attributes
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @return [io.appwrite.models.AttributeList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listAttributes(
		databaseId: String,
		collectionId: String
	): io.appwrite.models.AttributeList {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeList = {
            io.appwrite.models.AttributeList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeList::class.java,
            converter,
        )
    }
    
    /**
     * Create Boolean Attribute
     *
     * Create a boolean attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeBoolean]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createBooleanAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: Boolean? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeBoolean {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/boolean".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeBoolean = {
            io.appwrite.models.AttributeBoolean.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeBoolean::class.java,
            converter,
        )
    }
    
    /**
     * Create DateTime Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for the attribute in ISO 8601 format. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeDatetime]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDatetimeAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeDatetime {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/datetime".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeDatetime = {
            io.appwrite.models.AttributeDatetime.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeDatetime::class.java,
            converter,
        )
    }
    
    /**
     * Create Email Attribute
     *
     * Create an email attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEmail]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEmailAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeEmail {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/email".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeEmail = {
            io.appwrite.models.AttributeEmail.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeEmail::class.java,
            converter,
        )
    }
    
    /**
     * Create Enum Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param elements Array of elements in enumerated type. Uses length of longest element to determine size. Maximum of 100 elements are allowed, each 4096 characters long.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeEnum]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createEnumAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		elements: List<String>,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeEnum {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/enum".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "elements" to elements,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeEnum = {
            io.appwrite.models.AttributeEnum.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeEnum::class.java,
            converter,
        )
    }
    
    /**
     * Create Float Attribute
     *
     * Create a float attribute. Optionally, minimum and maximum values can be
     * provided.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeFloat]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createFloatAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		min: Double? = null,
		max: Double? = null,
		default: Double? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeFloat {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/float".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeFloat = {
            io.appwrite.models.AttributeFloat.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeFloat::class.java,
            converter,
        )
    }
    
    /**
     * Create Integer Attribute
     *
     * Create an integer attribute. Optionally, minimum and maximum values can be
     * provided.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value to enforce on new documents
     * @param max Maximum value to enforce on new documents
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeInteger]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIntegerAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		min: Long? = null,
		max: Long? = null,
		default: Long? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeInteger {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/integer".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeInteger = {
            io.appwrite.models.AttributeInteger.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeInteger::class.java,
            converter,
        )
    }
    
    /**
     * Create IP Address Attribute
     *
     * Create IP address attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeIp]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIpAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeIp {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/ip".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeIp = {
            io.appwrite.models.AttributeIp.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeIp::class.java,
            converter,
        )
    }
    
    /**
     * Create String Attribute
     *
     * Create a string attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param size Attribute size for text attributes, in number of characters.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeString]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createStringAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		size: Long,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeString {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/string".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "size" to size,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeString = {
            io.appwrite.models.AttributeString.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeString::class.java,
            converter,
        )
    }
    
    /**
     * Create URL Attribute
     *
     * Create a URL attribute.
     * 
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @return [io.appwrite.models.AttributeUrl]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createUrlAttribute(
		databaseId: String,
		collectionId: String,
		key: String,
		required: Boolean,
		default: String? = null,
		array: Boolean? = null
	): io.appwrite.models.AttributeUrl {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/url".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.AttributeUrl = {
            io.appwrite.models.AttributeUrl.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.AttributeUrl::class.java,
            converter,
        )
    }
    
    /**
     * Get Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getAttribute(
		databaseId: String,
		collectionId: String,
		key: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Delete Attribute
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteAttribute(
		databaseId: String,
		collectionId: String,
		key: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
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
     * List Documents
     *
     * Get a list of all the user's documents in a given collection. You can use
     * the query params to filter your results. On admin mode, this endpoint will
     * return a list of all of documents belonging to the provided collectionId.
     * [Learn more about different API modes](/docs/admin).
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long.
     * @return [io.appwrite.models.DocumentList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listDocuments(
		databaseId: String,
		collectionId: String,
		queries: List<String>? = null
	): io.appwrite.models.DocumentList {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "queries" to queries
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.DocumentList = {
            io.appwrite.models.DocumentList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.DocumentList::class.java,
            converter,
        )
    }
    
    /**
     * Create Document
     *
     * Create a new Document. Before using this route, you should create a new
     * collection resource using either a [server
     * integration](/docs/server/databases#databasesCreateCollection) API or
     * directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose your own unique ID or pass the string "unique()" to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default the current user is granted with all permissions. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createDocument(
		databaseId: String,
		collectionId: String,
		documentId: String,
		data: Any,
		permissions: List<String>? = null
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to data,
            "permissions" to permissions
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Get Document
     *
     * Get a document by its unique ID. This endpoint response returns a JSON
     * object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getDocument(
		databaseId: String,
		collectionId: String,
		documentId: String
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Update Document
     *
     * Update a document by its unique ID. Using the patch method you can pass
     * only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default the current permissions are inherited. [Learn more about permissions](/docs/permissions).
     * @return [io.appwrite.models.Document]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateDocument(
		databaseId: String,
		collectionId: String,
		documentId: String,
		data: Any? = null,
		permissions: List<String>? = null
	): io.appwrite.models.Document {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
        val params = mutableMapOf<String, Any?>(
            "data" to data,
            "permissions" to permissions
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Document = {
            io.appwrite.models.Document.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Document::class.java,
            converter,
        )
    }
    
    /**
     * Delete Document
     *
     * Delete a document by its unique ID.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteDocument(
		databaseId: String,
		collectionId: String,
		documentId: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{documentId}", documentId)
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
     * List Indexes
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @return [io.appwrite.models.IndexList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun listIndexes(
		databaseId: String,
		collectionId: String
	): io.appwrite.models.IndexList {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.IndexList = {
            io.appwrite.models.IndexList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.IndexList::class.java,
            converter,
        )
    }
    
    /**
     * Create Index
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @param type Index type.
     * @param attributes Array of attributes to index. Maximum of 100 attributes are allowed, each 32 characters long.
     * @param orders Array of index orders. Maximum of 100 orders are allowed.
     * @return [io.appwrite.models.Index]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createIndex(
		databaseId: String,
		collectionId: String,
		key: String,
		type: String,
		attributes: List<String>,
		orders: List<String>? = null
	): io.appwrite.models.Index {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId)
        val params = mutableMapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "attributes" to attributes,
            "orders" to orders
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Index::class.java,
            converter,
        )
    }
    
    /**
     * Get Index
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @return [io.appwrite.models.Index]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getIndex(
		databaseId: String,
		collectionId: String,
		key: String
	): io.appwrite.models.Index {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Index = {
            io.appwrite.models.Index.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Index::class.java,
            converter,
        )
    }
    
    /**
     * Delete Index
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteIndex(
		databaseId: String,
		collectionId: String,
		key: String
	): Any {
        val path = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}".replace("{databaseId}", databaseId).replace("{collectionId}", collectionId).replace("{key}", key)
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
    
}
