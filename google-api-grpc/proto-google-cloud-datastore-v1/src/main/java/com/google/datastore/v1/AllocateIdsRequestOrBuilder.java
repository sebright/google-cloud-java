// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/datastore/v1/datastore.proto

package com.google.datastore.v1;

public interface AllocateIdsRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:google.datastore.v1.AllocateIdsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8;</code>
   */
  java.lang.String getProjectId();
  /**
   * <pre>
   * The ID of the project against which to make the request.
   * </pre>
   *
   * <code>string project_id = 8;</code>
   */
  com.google.protobuf.ByteString
      getProjectIdBytes();

  /**
   * <pre>
   * A list of keys with incomplete key paths for which to allocate IDs.
   * No key may be reserved/read-only.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  java.util.List<com.google.datastore.v1.Key> 
      getKeysList();
  /**
   * <pre>
   * A list of keys with incomplete key paths for which to allocate IDs.
   * No key may be reserved/read-only.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  com.google.datastore.v1.Key getKeys(int index);
  /**
   * <pre>
   * A list of keys with incomplete key paths for which to allocate IDs.
   * No key may be reserved/read-only.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  int getKeysCount();
  /**
   * <pre>
   * A list of keys with incomplete key paths for which to allocate IDs.
   * No key may be reserved/read-only.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  java.util.List<? extends com.google.datastore.v1.KeyOrBuilder> 
      getKeysOrBuilderList();
  /**
   * <pre>
   * A list of keys with incomplete key paths for which to allocate IDs.
   * No key may be reserved/read-only.
   * </pre>
   *
   * <code>repeated .google.datastore.v1.Key keys = 1;</code>
   */
  com.google.datastore.v1.KeyOrBuilder getKeysOrBuilder(
      int index);
}