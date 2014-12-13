package com.google.gcloud.datastore;

import static com.google.api.client.util.Preconditions.checkNotNull;

import com.google.api.services.datastore.DatastoreV1;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.gcloud.datastore.QueryResult.Type;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.InvalidProtocolBufferException;


// TODO(ozarov): add a usage examples (gql and regular)
/**
 * A Google Cloud Datastore query.
 *
 * @param <T> the type of the values returned by this query.
 * @see <a href="https://cloud.google.com/datastore/docs/concepts/queries">Datastore Queries</a>
 */
public abstract class Query<T> extends Serializable<GeneratedMessage> {

  private static final long serialVersionUID = -2748141759901313101L;

  private final ResultType<T> resultType;
  private final String namespace;

  public static class ResultType<T> implements java.io.Serializable {

    private static final long serialVersionUID = 2104157695425806623L;
    private static final ResultType<?> UNKNOWN = new ResultType<>(null, null);
    private static final ResultType<Entity> FULL = new ResultType<>(Entity.class, Type.FULL);
    private static final ResultType<Key> KEY_ONLY = new ResultType<>(Key.class, Type.KEY_ONLY);
    private static final ResultType<PartialEntity> PROJECTION =
        new ResultType<>(PartialEntity.class, Type.PROJECTION);


    private final Class<T> clazz;
    private final Type type;

    private ResultType(Class<T> clazz, Type type) {
      this.clazz = clazz;
      this.type = type;
    }

    public Type getType() {
      return type;
    }

    public Class<T> getResultClass() {
      return clazz;
    }

    public static ResultType<?> unknown() {
      return UNKNOWN;
    }

    public static ResultType<Entity> full() {
      return FULL;
    }

    public static ResultType<PartialEntity> projection() {
      return PROJECTION;
    }

    public static ResultType<Key> keyOnly() {
      return KEY_ONLY;
    }
  }

  Query(ResultType<T> resultType, String namespace) {
    this.resultType = checkNotNull(resultType);
    this.namespace = namespace;
  }

  public ResultType<T> resultType() {
    return resultType;
  }

  public String namespace() {
    return namespace;
  }

  @Override
  public String toString() {
    ToStringHelper toStringHelper = MoreObjects.toStringHelper(this);
    toStringHelper.add("namespace", namespace);
    toStringHelper.add("queryPb", super.toString());
    return toStringHelper.toString();
  }

  @Override
  protected Object fromPb(byte[] bytesPb) throws InvalidProtocolBufferException {
    return fromPb(resultType, namespace, bytesPb);
  }

  protected abstract Object fromPb(ResultType<T> resultType, String namespace, byte[] bytesPb)
      throws InvalidProtocolBufferException;

  protected abstract void populatePb(DatastoreV1.RunQueryRequest.Builder requestPb);

  protected abstract Query<T> nextQuery(DatastoreV1.QueryResultBatch responsePb);
}
