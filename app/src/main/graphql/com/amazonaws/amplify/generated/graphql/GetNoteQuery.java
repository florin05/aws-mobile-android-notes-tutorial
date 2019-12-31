package com.amazonaws.amplify.generated.graphql;

import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import java.io.IOException;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import type.CustomType;

@Generated("Apollo GraphQL")
public final class GetNoteQuery implements Query<GetNoteQuery.Data, GetNoteQuery.Data, GetNoteQuery.Variables> {
  public static final String OPERATION_DEFINITION = "query GetNote($id: ID!) {\n"
      + "  getNote(id: $id) {\n"
      + "    __typename\n"
      + "    id\n"
      + "    title\n"
      + "    content\n"
      + "    blabla\n"
      + "    _version\n"
      + "    _deleted\n"
      + "    _lastChangedAt\n"
      + "    owner\n"
      + "  }\n"
      + "}";

  public static final String QUERY_DOCUMENT = OPERATION_DEFINITION;

  private static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "GetNote";
    }
  };

  private final GetNoteQuery.Variables variables;

  public GetNoteQuery(@Nonnull String id) {
    Utils.checkNotNull(id, "id == null");
    variables = new GetNoteQuery.Variables(id);
  }

  @Override
  public String operationId() {
    return "ba81654ff6cd9b062ef02bb296492c3a6ccad16d11e661c284d286adae29774b";
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public GetNoteQuery.Data wrapData(GetNoteQuery.Data data) {
    return data;
  }

  @Override
  public GetNoteQuery.Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<GetNoteQuery.Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    private @Nonnull String id;

    Builder() {
    }

    public Builder id(@Nonnull String id) {
      this.id = id;
      return this;
    }

    public GetNoteQuery build() {
      Utils.checkNotNull(id, "id == null");
      return new GetNoteQuery(id);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @Nonnull String id;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@Nonnull String id) {
      this.id = id;
      this.valueMap.put("id", id);
    }

    public @Nonnull String id() {
      return id;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeString("id", id);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forObject("getNote", "getNote", new UnmodifiableMapBuilder<String, Object>(1)
        .put("id", new UnmodifiableMapBuilder<String, Object>(2)
          .put("kind", "Variable")
          .put("variableName", "id")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable GetNote getNote;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public Data(@Nullable GetNote getNote) {
      this.getNote = getNote;
    }

    public @Nullable GetNote getNote() {
      return this.getNote;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeObject($responseFields[0], getNote != null ? getNote.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "getNote=" + getNote
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.getNote == null) ? (that.getNote == null) : this.getNote.equals(that.getNote));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (getNote == null) ? 0 : getNote.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final GetNote.Mapper getNoteFieldMapper = new GetNote.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final GetNote getNote = reader.readObject($responseFields[0], new ResponseReader.ObjectReader<GetNote>() {
          @Override
          public GetNote read(ResponseReader reader) {
            return getNoteFieldMapper.map(reader);
          }
        });
        return new Data(getNote);
      }
    }
  }

  public static class GetNote {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("id", "id", null, false, CustomType.ID, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("title", "title", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("content", "content", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("blabla", "blabla", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("_version", "_version", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forBoolean("_deleted", "_deleted", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forCustomType("_lastChangedAt", "_lastChangedAt", null, false, CustomType.AWSTIMESTAMP, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("owner", "owner", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nonnull String __typename;

    final @Nonnull String id;

    final @Nonnull String title;

    final @Nonnull String content;

    final @Nonnull String blabla;

    final int _version;

    final @Nullable Boolean _deleted;

    final long _lastChangedAt;

    final @Nullable String owner;

    private volatile String $toString;

    private volatile int $hashCode;

    private volatile boolean $hashCodeMemoized;

    public GetNote(@Nonnull String __typename, @Nonnull String id, @Nonnull String title,
        @Nonnull String content, @Nonnull String blabla, int _version, @Nullable Boolean _deleted,
        long _lastChangedAt, @Nullable String owner) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = Utils.checkNotNull(id, "id == null");
      this.title = Utils.checkNotNull(title, "title == null");
      this.content = Utils.checkNotNull(content, "content == null");
      this.blabla = Utils.checkNotNull(blabla, "blabla == null");
      this._version = _version;
      this._deleted = _deleted;
      this._lastChangedAt = _lastChangedAt;
      this.owner = owner;
    }

    public @Nonnull String __typename() {
      return this.__typename;
    }

    public @Nonnull String id() {
      return this.id;
    }

    public @Nonnull String title() {
      return this.title;
    }

    public @Nonnull String content() {
      return this.content;
    }

    public @Nonnull String blabla() {
      return this.blabla;
    }

    public int _version() {
      return this._version;
    }

    public @Nullable Boolean _deleted() {
      return this._deleted;
    }

    public long _lastChangedAt() {
      return this._lastChangedAt;
    }

    public @Nullable String owner() {
      return this.owner;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[1], id);
          writer.writeString($responseFields[2], title);
          writer.writeString($responseFields[3], content);
          writer.writeString($responseFields[4], blabla);
          writer.writeInt($responseFields[5], _version);
          writer.writeBoolean($responseFields[6], _deleted);
          writer.writeCustom((ResponseField.CustomTypeField) $responseFields[7], _lastChangedAt);
          writer.writeString($responseFields[8], owner);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "GetNote{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "title=" + title + ", "
          + "content=" + content + ", "
          + "blabla=" + blabla + ", "
          + "_version=" + _version + ", "
          + "_deleted=" + _deleted + ", "
          + "_lastChangedAt=" + _lastChangedAt + ", "
          + "owner=" + owner
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof GetNote) {
        GetNote that = (GetNote) o;
        return this.__typename.equals(that.__typename)
         && this.id.equals(that.id)
         && this.title.equals(that.title)
         && this.content.equals(that.content)
         && this.blabla.equals(that.blabla)
         && this._version == that._version
         && ((this._deleted == null) ? (that._deleted == null) : this._deleted.equals(that._deleted))
         && this._lastChangedAt == that._lastChangedAt
         && ((this.owner == null) ? (that.owner == null) : this.owner.equals(that.owner));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= id.hashCode();
        h *= 1000003;
        h ^= title.hashCode();
        h *= 1000003;
        h ^= content.hashCode();
        h *= 1000003;
        h ^= blabla.hashCode();
        h *= 1000003;
        h ^= _version;
        h *= 1000003;
        h ^= (_deleted == null) ? 0 : _deleted.hashCode();
        h *= 1000003;
        h ^= _lastChangedAt;
        h *= 1000003;
        h ^= (owner == null) ? 0 : owner.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<GetNote> {
      @Override
      public GetNote map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String id = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[1]);
        final String title = reader.readString($responseFields[2]);
        final String content = reader.readString($responseFields[3]);
        final String blabla = reader.readString($responseFields[4]);
        final int _version = reader.readInt($responseFields[5]);
        final Boolean _deleted = reader.readBoolean($responseFields[6]);
        final long _lastChangedAt = reader.readCustomType((ResponseField.CustomTypeField) $responseFields[7]);
        final String owner = reader.readString($responseFields[8]);
        return new GetNote(__typename, id, title, content, blabla, _version, _deleted, _lastChangedAt, owner);
      }
    }
  }
}
